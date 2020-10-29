package datdvt.pages;

import datdvt.clients.CategoryClient;
import datdvt.clients.ColorClient;
import datdvt.clients.ImageClient;
import datdvt.clients.ProductClient;
import datdvt.clients.WebsiteCategoryClient;
import datdvt.dtos.CategoryDTO;
import datdvt.dtos.ColorDTO;
import datdvt.dtos.ColorsDTO;
import datdvt.dtos.ImageDTO;
import datdvt.dtos.ProductDTO;
import datdvt.dtos.WebsiteCategoryDTO;
import datdvt.htmlutils.HTMLClarifier;
import datdvt.htmlutils.UltimateCrawler;
import datdvt.htmlutils.XMLClarifier;
import datdvt.imageutils.ColorDominant;
import datdvt.imageutils.ImageSave;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class NoiThatAmber {

    public final String AMBER_URL = "https://noithatamber.vn";
    protected String path;
    protected String message;

    public NoiThatAmber(String path) {
        this.path = path + "WEB-INF\\";
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void getCateogryOfAmber() throws Exception {
        boolean getHTML = HTMLClarifier.getXMLToFile(AMBER_URL, path + "noithatamber.xml");
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + "noithatamber.xml", path + "amber_category.xsl", path + "amber_rs.xml");
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + "amber_rs.xml");
                NodeList categoryList = doc.getFirstChild().getChildNodes();
                for (int i = 0; i < categoryList.getLength(); i++) {
                    if (categoryList.item(i).getNodeName().trim().equals("category")) {
                        Node itemLink = XMLClarifier.moveToChildNode(categoryList.item(i), "link");
                        Node itemName = XMLClarifier.moveToChildNode(categoryList.item(i), "name");
                        CategoryClient client = new CategoryClient();
                        WebsiteCategoryClient ccclient = new WebsiteCategoryClient();
                        String removeWebsiteUrl = itemLink.getTextContent().replace(AMBER_URL, "");
                        String valueCategoryDecode = URLDecoder.decode(removeWebsiteUrl, StandardCharsets.UTF_8.toString());
                        String converturl = valueCategoryDecode.replace("/", "*slash*");
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
                            WebsiteCategoryDTO dto = new WebsiteCategoryDTO(generateId, itemName.getTextContent(), valueCategoryDecode, AMBER_URL, client.find_XML(CategoryDTO.class, "1"));
                            ccclient.create_XML(dto);
                        }
                    }
                }
            }
        }
    }

    public void getProductsOfAmber(String categoryUrl) throws Exception {
        System.out.println("Starting Crawl");
        boolean getHTML = HTMLClarifier.getXMLToFile(AMBER_URL + categoryUrl,path+ "amber_product_list.xml");
        System.out.println("Processing");
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + "amber_product_list.xml", path + "amber_products.xsl", path + "amber_product_list_rs.xml");
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + "amber_product_list_rs.xml");
                String page = XMLClarifier.moveToChildNode(doc.getFirstChild(), "numberpage").getTextContent();
                int numberPage = 1;
                if (!page.equals("")) {
                    numberPage = Integer.parseInt(page);
                }
                if (numberPage >= 10) {
                    numberPage = 10;
                }
                for (int i = 1; i <= numberPage; i++) {
                    String convertURL = URLEncoder.encode(categoryUrl, StandardCharsets.UTF_8.toString());
                    boolean getListProductHtml = HTMLClarifier.getXMLToFile(AMBER_URL + "/" + convertURL + "#/pageNumber=" + i, path + "amber_product_page_list.xml");
                    if (getListProductHtml) {
                        boolean applyPageXsl = UltimateCrawler.ultimateCrawl(path + "amber_product_page_list.xml", path + "amber_products.xsl", path + "amber_product_page_list_rs.xml");
                        if (applyPageXsl) {
                            Document subdoc = XMLClarifier.parseFileToDom(path + "amber_product_page_list_rs.xml");
                            Node listnode = XMLClarifier.moveToChildNode(subdoc.getFirstChild(), "list");
                            NodeList productList = listnode.getChildNodes();
                            for (int j = 0; j < productList.getLength(); j++) {
                                if (productList.item(j).getNodeName().trim().equals("category")) {
                                    Node getLink = XMLClarifier.moveToChildNode(productList.item(j), "link");
                                    String producturl = getLink.getTextContent();
                                    getProductDetailOfAmber(producturl, categoryUrl);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void getProductDetailOfAmber(String producturl, String categoryWebsiteUrl) throws Exception {
        boolean getHTML = HTMLClarifier.getXMLToFile(AMBER_URL + producturl, path + "amber_product_detail.xml");
        if (getHTML) {
            boolean applyXsl = UltimateCrawler.ultimateCrawl(path + "amber_product_detail.xml", path + "amber_product_detail.xsl", path + "amber_product_detail_rs.xml");
            if (applyXsl) {
                Document doc = XMLClarifier.parseFileToDom(path + "amber_product_detail_rs.xml");
                ProductDTO dto = new ProductDTO();
                List<ColorDTO> tmpColors = new ArrayList<ColorDTO>();
                dto.setUrl(AMBER_URL + producturl);
                WebsiteCategoryClient wclient = new WebsiteCategoryClient();
                String valueCategory = URLDecoder.decode(categoryWebsiteUrl, StandardCharsets.UTF_8.toString());
                String converturl = valueCategory.replace("/", "*slash*");
                WebsiteCategoryDTO wdto = wclient.getWebsiteCategoryByUrl_XML(WebsiteCategoryDTO.class, converturl.toString());
                dto.setWebsiteCategory(wdto);
                NodeList detailNode = doc.getFirstChild().getChildNodes();
                for (int i = 0; i < detailNode.getLength(); i++) {
                    Node tmp = detailNode.item(i);
                    if (tmp.getNodeName().equals("name")) {
                        dto.setName(tmp.getTextContent());
                    } else if (tmp.getNodeName().equals("price")) {
                        dto.setPrice(Integer.parseInt(tmp.getTextContent()));
                    } else if (tmp.getNodeName().equals("colors")) {
                        NodeList colorList = tmp.getChildNodes();
                        for (int j = 0; j < colorList.getLength(); j++) {
                            String urlImage = colorList.item(j).getTextContent();
                            ColorClient cclient = new ColorClient();
                            if (!urlImage.trim().equals("")) {
                                ImageSave.saveImage(colorList.item(j).getTextContent(), path + "image.jpg");
                                Integer[] rgbColor = ColorDominant.getPrimaryColor(path + "image.jpg");
                                ColorDTO colorDTO = cclient.getColorByRGB_XML(ColorDTO.class, String.valueOf(rgbColor[0]), String.valueOf(rgbColor[1]), String.valueOf(rgbColor[2]));
                                if (colorDTO == null) {
                                    int generateId = Integer.parseInt(cclient.getCount_XML()) + 1;
                                    String hexaColor = String.format("%02x%02x%02x", rgbColor[0], rgbColor[1], rgbColor[2]);
                                    ColorDTO generateDto = new ColorDTO(generateId, hexaColor, rgbColor[0], rgbColor[1], rgbColor[2]);
                                    cclient.create_XML(generateDto);
                                    tmpColors.add(generateDto);
                                } else {
                                    tmpColors.add(colorDTO);
                                }
                            }
                        }
                    } else if (tmp.getNodeName().equals("size")) {
                        NodeList sizeNodes = tmp.getChildNodes();
                        for (int j = 0; j < sizeNodes.getLength(); j++) {
                            Node subtmp = sizeNodes.item(j);
                            if (subtmp.getNodeName().equals("width")) {
                                if (!subtmp.getTextContent().equals("")) {
                                    try {
                                        dto.setWidth(Float.parseFloat(subtmp.getTextContent()) / 10);
                                    } catch (Exception e) {
                                    }
                                } else {
                                    dto.setWidth(0);
                                }
                            }
                            if (subtmp.getNodeName().equals("height")) {
                                if (!subtmp.getTextContent().equals("")) {
                                    try {
                                        dto.setHeight(Float.parseFloat(subtmp.getTextContent()) / 10);
                                    } catch (Exception e) {
                                    }
                                } else {
                                    dto.setDepth(0);
                                }
                            }
                            if (subtmp.getNodeName().equals("dept")) {
                                if (!subtmp.getTextContent().equals("")) {
                                    try {
                                        dto.setDepth(Float.parseFloat(subtmp.getTextContent()) / 10);
                                    } catch (Exception e) {
                                    }
                                } else {
                                    dto.setHeight(0);
                                }
                            }
                        }
                    } else if (tmp.getNodeName().equals("material")) {
                        String material = tmp.getTextContent().trim();
//                        dto.setMaterial(material);
//                          System.out.println("tmp "+tmp.getTextContent());
//                          dto.setMaterial(new String(tmp.getTextContent().getBytes(), StandardCharsets.US_ASCII));
//                          dto.setMaterial("Ván MDF chống ẩm 17 mm");
//                          dto.setMaterial("V&amp;#xE1;n MDF ch&amp;#x1ED1;ng &amp;#x1EA9;m v&amp;#xE2;n g&amp;#x1ED7; s&amp;#x1ED3;i, ch&amp;#xE2;n g&amp;#x1ED7; Walnut");
                    }
                }
                ProductClient pclient = new ProductClient();
                String valueURLDecode = URLDecoder.decode(dto.getUrl(), StandardCharsets.UTF_8.toString());
                String convertProductUrl = valueURLDecode.replace("/", "*slash*");
                dto.setUrl(valueURLDecode);
                ProductDTO getExistProduct = pclient.getProductByUrl_XML(ProductDTO.class, convertProductUrl);
                if (getExistProduct == null) {
                    System.out.print("New Element: ");
                    message += "New Element: ";
                    int generateProductId = Integer.parseInt(pclient.getCount_XML()) + 1;
                    dto.setId(generateProductId);
//                    dto.setMaterial("SS");
//                    System.out.println("Material" + dto.getMaterial());
                    pclient.create_XML(dto);
                    Node imageNode = XMLClarifier.moveToChildNode(doc.getFirstChild(), "image");
                    ImageClient iclient = new ImageClient();
                    if (tmpColors.size() == 0) {
                        ColorDTO tmpColor;
                        ImageSave.saveImage(imageNode.getTextContent(), path + "image.jpg");
                        ColorClient cclient = new ColorClient();
                        int[] rgbColor = ColorDominant.getHexColor(path + "image.jpg");
                        ColorDTO colorDTO = cclient.getColorByRGB_XML(ColorDTO.class, String.valueOf(rgbColor[0]), String.valueOf(rgbColor[1]), String.valueOf(rgbColor[2]));
                        if (colorDTO == null) {
                            int generateId = Integer.parseInt(cclient.getCount_XML()) + 1;
                            String hexaColor = String.format("%02x%02x%02x", rgbColor[0], rgbColor[1], rgbColor[2]);
                            ColorDTO generateDto = new ColorDTO(generateId, hexaColor, rgbColor[0], rgbColor[1], rgbColor[2]);
                            cclient.create_XML(generateDto);
                            tmpColor = generateDto;
                        } else {
                            tmpColor = colorDTO;
                        }
                        int generateId = Integer.parseInt(iclient.getCount_XML()) + 1;
                        ImageDTO imageDto = new ImageDTO(generateId, imageNode.getTextContent(), dto, tmpColor);
                        iclient.create_XML(imageDto);
                    } else {
                        for (int i = 0; i < tmpColors.size(); i++) {
                            int generateId = Integer.parseInt(iclient.getCount_XML()) + 1;
                            ImageDTO imageDto = new ImageDTO(generateId, imageNode.getTextContent(), dto, tmpColors.get(i));
                            iclient.create_XML(imageDto);
                        }
                    }
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
                    System.out.println(getExistProduct.getName());
                }
                message += dto.getName() + "<br/>";
            }
        }
    }

    public static void main(String[] args) throws Exception {
        NoiThatAmber n = new NoiThatAmber("web\\");
//        n.getCateogryOfAmber();
//        n.getProductsOfAmber("/furniture");

        ColorClient clc = new ColorClient();
        List<ColorDTO> cololist = ((ColorsDTO) clc.getNearestColor_XML(ColorsDTO.class, "40", "47", "54", "15", "100")).getList();
        System.out.println(cololist.size());
        for (int i = 0; i < cololist.size(); i++) {
            System.out.println(cololist.get(i).getR()+"-"+cololist.get(i).getG()+"-"+cololist.get(i).getB());
        }

    }
}
