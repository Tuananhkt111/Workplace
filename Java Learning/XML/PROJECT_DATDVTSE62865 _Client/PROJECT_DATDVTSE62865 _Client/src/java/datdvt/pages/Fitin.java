/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datdvt.pages;

import datdvt.clients.BrandClient;
import datdvt.clients.CategoryClient;
import datdvt.clients.ColorClient;
import datdvt.clients.ImageClient;
import datdvt.clients.ProductClient;
import datdvt.clients.WebsiteCategoryClient;
import datdvt.dtos.BrandDTO;
import datdvt.dtos.WebsiteCategoryDTO;
import datdvt.dtos.CategoryDTO;
import datdvt.dtos.ColorDTO;
import datdvt.dtos.ImageDTO;
import datdvt.dtos.ProductDTO;
import datdvt.htmlutils.HTMLClarifier;
import datdvt.htmlutils.UltimateCrawler;
import datdvt.htmlutils.XMLClarifier;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Admin
 */
public class Fitin {

    public final String FITIN_URL = "https://fitin.vn";
    public final String fitinXML = "fitin.xml";
    public final String fitinCategoryXML = "fitin_category.xml";
    private String path;
    private String message;

    public Fitin(String path) {
        this.path = path + "WEB-INF\\";
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<WebsiteCategoryDTO> getWebsiteCategoryList(String website) {
        WebsiteCategoryClient client = new WebsiteCategoryClient();
        List<WebsiteCategoryDTO> list = (List) client.getWebsiteCategoryByWebsite_XML(WebsiteCategoryDTO.class, website);
        return list;
    }

    public void getCateogryOfFitin() throws Exception {
        boolean getHTML = HTMLClarifier.getXMLToFile(FITIN_URL, path + fitinXML);
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + fitinXML, path + "fitin_category.xsl", path + fitinCategoryXML);
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + fitinCategoryXML);
                NodeList categoryList = doc.getFirstChild().getChildNodes();
                for (int i = 0; i < categoryList.getLength(); i++) {
                    if (categoryList.item(i).getNodeName().equals("category")) {
                        Node itemLink = XMLClarifier.moveToChildNode(categoryList.item(i), "link");
                        Node itemName = XMLClarifier.moveToChildNode(categoryList.item(i), "name");
                        CategoryClient client = new CategoryClient();
                        WebsiteCategoryClient ccclient = new WebsiteCategoryClient();
                        String converturl = itemLink.getTextContent().replace("/", "*slash*");
                        WebsiteCategoryDTO wdto = ccclient.getWebsiteCategoryByUrl_XML(WebsiteCategoryDTO.class, converturl);
                        if (wdto != null) {
                            String xml = ccclient.getWebsiteCategoryByUrl_XML(String.class, converturl);
                            String tmpXML = xml.replace("<websiteCategory>", "<websiteCategory xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "
                                    + "xmlns='http://xml.netbeans.org/schema/websiteCategory' "
                                    + "xsi:schemaLocation='http://xml.netbeans.org/schema/websiteCategory websiteCategory.xsd'>");
                            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                            Schema schema = schemaFactory.newSchema(new File(path + "websiteCategory.xsd"));
                            Source source = new StreamSource(new ByteArrayInputStream(tmpXML.getBytes("UTF-8")));
                            try {
                                Validator validator = schema.newValidator();
                                validator.validate(source);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (wdto == null) {
                            System.out.println("Create new element: " + itemName.getTextContent());
                            int generateId = Integer.parseInt(ccclient.getCount_XML()) + 1;
                            WebsiteCategoryDTO dto = new WebsiteCategoryDTO(generateId, itemName.getTextContent(), itemLink.getTextContent(), FITIN_URL, client.find_XML(CategoryDTO.class, "1"));
                            ccclient.create_XML(dto);
                        }
                    }
                }
            }
        }
    }

    public void getProductsOfFitin(String categoryUrl) throws Exception {
        System.out.println("Starting Crawl");
        boolean getHTML = HTMLClarifier.getXMLToFile(FITIN_URL + categoryUrl, path + "fitin_product_list.xml");
        System.out.println("Processing");
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + "fitin_product_list.xml", path + "fitin_products.xsl", path + "fitin_product_list_rs.xml");
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + "fitin_product_list_rs.xml");
                String page = XMLClarifier.moveToChildNode(doc.getFirstChild(), "numberpage").getTextContent();
                int numberPage = 1;
                if (!page.equals("")) {
                    numberPage = Integer.parseInt(page);
                }
                if (numberPage >= 1) {
                    numberPage = 1;
                }
                for (int i = 1; i <= numberPage; i++) {
                    boolean getListProductHtml = HTMLClarifier.getXMLToFile(FITIN_URL + categoryUrl + "?page=" + i, path + "fitin_product_page_list.xml");
                    if (getListProductHtml) {
                        boolean applyPageXsl = UltimateCrawler.ultimateCrawl(path + "fitin_product_page_list.xml", path + "fitin_products.xsl", path + "fitin_product_page_list_rs.xml");
                        if (applyPageXsl) {
                            Document subdoc = XMLClarifier.parseFileToDom(path + "fitin_product_page_list_rs.xml");
                            Node listnode = XMLClarifier.moveToChildNode(subdoc.getFirstChild(), "list");
                            NodeList productList = listnode.getChildNodes();
                            for (int j = 0; j < productList.getLength(); j++) {
                                if (productList.item(j).getNodeName().trim().equals("category")) {
                                    Node getLink = XMLClarifier.moveToChildNode(productList.item(j), "link");
                                    String producturl = getLink.getTextContent();
                                    getProductDetailOfFitin(producturl, categoryUrl);
                                    System.out.println(producturl);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void getProductDetailOfFitin(String producturl, String categoryWebsiteUrl) throws Exception {
        boolean getHTML = HTMLClarifier.getXMLToFile(FITIN_URL + producturl, path + "fitin_product_detail.xml");
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + "fitin_product_detail.xml", path + "fitin_product_detail.xsl", path + "fitin_product_detail_rs.xml");
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + "fitin_product_detail_rs.xml");
                ProductDTO dto = new ProductDTO();
                ColorDTO tmpColor = null;
                dto.setUrl(FITIN_URL + producturl);
                WebsiteCategoryClient wclient = new WebsiteCategoryClient();
                String converturl = categoryWebsiteUrl.replace("/", "*slash*");
                WebsiteCategoryDTO wdto = wclient.getWebsiteCategoryByUrl_XML(WebsiteCategoryDTO.class, converturl);
                dto.setWebsiteCategory(wdto);
                NodeList detailNode = doc.getFirstChild().getChildNodes();
                for (int i = 0; i < detailNode.getLength(); i++) {
                    Node tmp = detailNode.item(i);
                    if (tmp.getNodeName().equals("name")) {
                        dto.setName(tmp.getTextContent());
                    } else if (tmp.getNodeName().equals("brand")) {
                        BrandClient bclient = new BrandClient();
                        BrandDTO brandDTO = bclient.getBrandByName_XML(BrandDTO.class, tmp.getTextContent());
                        if (brandDTO == null) {
                            int generateId = Integer.parseInt(bclient.getCount_XML()) + 1;
                            BrandDTO generateDto = new BrandDTO(generateId, tmp.getTextContent());
                            bclient.create_XML(generateDto);
                            dto.setBrand(generateDto);
                        } else {
                            dto.setBrand(brandDTO);
                        }
                    } else if (tmp.getNodeName().equals("price")) {
                        dto.setPrice(Integer.parseInt(tmp.getTextContent()));
                    } else if (tmp.getNodeName().equals("color")) {
                        ColorClient cclient = new ColorClient();
                        String hexaColor = tmp.getTextContent().trim();
                        int rColor = Integer.parseInt(hexaColor.substring(0, 2), 16);
                        int gColor = Integer.parseInt(hexaColor.substring(2, 4), 16);
                        int bColor = Integer.parseInt(hexaColor.substring(4, 6), 16);

                        ColorDTO colorDTO = cclient.getColorByRGB_XML(ColorDTO.class, String.valueOf(rColor), String.valueOf(gColor), String.valueOf(bColor));
                        if (colorDTO == null) {
                            int generateId = Integer.parseInt(cclient.getCount_XML()) + 1;
                            ColorDTO generateDto = new ColorDTO(generateId, hexaColor, rColor, gColor, bColor);
                            cclient.create_XML(generateDto);
                            tmpColor = generateDto;
                        } else {
                            tmpColor = colorDTO;
                        }
                    } else if (tmp.getNodeName().equals("size")) {
                        NodeList sizeNodes = tmp.getChildNodes();
                        for (int j = 0; j < sizeNodes.getLength(); j++) {
                            Node subtmp = sizeNodes.item(j);
                            if (subtmp.getNodeName().equals("width") && !subtmp.getTextContent().equals("")) {
                                dto.setWidth(Float.parseFloat(subtmp.getTextContent()));
                            } else if (subtmp.getNodeName().equals("height") && !subtmp.getTextContent().equals("")) {
                                dto.setHeight(Float.parseFloat(subtmp.getTextContent()));
                            } else if (subtmp.getNodeName().equals("dept") && !subtmp.getTextContent().equals("")) {
                                dto.setDepth(Float.parseFloat(subtmp.getTextContent()));
                            }
                        }
                    } else if (tmp.getNodeName().equals("material")) {
                        dto.setMaterial(tmp.getTextContent());
                    }
                }
                ProductClient pclient = new ProductClient();
                String convertProductUrl = dto.getUrl().replace("/", "*slash*");
                ProductDTO getExistProduct = pclient.getProductByUrl_XML(ProductDTO.class, convertProductUrl);
                if (getExistProduct == null) {
                    System.out.print("New Element: ");
                    message += "New element: ";
                    int generateProductId = Integer.parseInt(pclient.getCount_XML()) + 1;
                    dto.setId(generateProductId);
                    pclient.create_XML(dto);
                    Node imageNode = XMLClarifier.moveToChildNode(doc.getFirstChild(), "image");
                    ImageClient iclient = new ImageClient();
                    int generateId = Integer.parseInt(iclient.getCount_XML()) + 1;
                    ImageDTO imageDto = new ImageDTO(generateId, imageNode.getTextContent(), dto, tmpColor);
                    iclient.create_XML(imageDto);
                } else {
                    System.out.print("Existed Element - updated: ");
                    message += "Existed Element - updated: ";

                    getExistProduct.setName("");
                    getExistProduct.setDepth(0);
                    getExistProduct.setHeight(0);
                    getExistProduct.setWidth(0);
                    getExistProduct.setMaterial("");
                    getExistProduct.setBrand(null);
                    getExistProduct.setPrice(0);
                    pclient.edit_XML(getExistProduct, String.valueOf(getExistProduct.getId()));
                    getExistProduct.setWidth(dto.getWidth());
                    getExistProduct.setName(dto.getName());
                    getExistProduct.setDepth(dto.getDepth());
                    getExistProduct.setHeight(dto.getHeight());
                    getExistProduct.setWidth(dto.getWidth());
                    getExistProduct.setMaterial(dto.getMaterial());
                    getExistProduct.setBrand(dto.getBrand());
                    getExistProduct.setPrice(dto.getPrice());
                    pclient.edit_XML(getExistProduct, String.valueOf(getExistProduct.getId()));
                }

                message += dto.getName() + "<br/>";

            }
        }

    }

    public static void main(String[] args) {
        try {
            Fitin fitin = new Fitin("web\\");
            fitin.getProductsOfFitin("/ban-sofa/c402");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
