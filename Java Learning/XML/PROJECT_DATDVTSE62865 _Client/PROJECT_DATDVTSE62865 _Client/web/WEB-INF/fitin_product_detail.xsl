<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : product_detail.xsl
    Created on : July 3, 2020, 8:21 PM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
xmlns:xh="http://www.w3.org/1999/xhtml">
    <xsl:output method="xml"  indent="yes" encoding="UTF-8"/>

    <!-- TODO customize transformation rules
         syntax recommendation http://www.w3.org/TR/xslt
    -->
    <xsl:template match="/">
        <product>
            <name>
                <xsl:value-of select="//div[contains(@class,'product-cart')]//h2[normalize-space(text())]"></xsl:value-of>
            </name>
            <brand>
                <xsl:value-of select="//div[@class='product-cart']//a[normalize-space(text())]"></xsl:value-of>
            </brand>
            <price>
                <xsl:variable name="textPrice" select="//div[contains(@class,'product-price cart-block')]//h4[normalize-space(text())]"/>
                <xsl:variable name="removedCommaPrice" select="translate($textPrice, ',', '')"/>
                <xsl:variable name="removeUnit" select="substring($removedCommaPrice, 1, string-length($removedCommaPrice) - 2)"/>
                <xsl:variable name="trimPrice" select="normalize-space($removeUnit)"/>
                <xsl:value-of select="$trimPrice"></xsl:value-of>
            </price>
            <color>
                <xsl:variable name="textColor" select="//div[@class='color-block']//button[contains(@class, 'color-btn active')]/@style"/>
                <xsl:variable name="removeTrashText" select="substring($textColor, 14, string-length($textColor))"/>
                <xsl:variable name="removeDotComma" select="translate($removeTrashText, ';', '')"/>
                <xsl:value-of select="normalize-space($removeDotComma)"></xsl:value-of>
            </color>
            <image>
                <xsl:value-of select="//div[contains(@class,'carousel carousel-main')]//img/@src"></xsl:value-of>
            </image>
            <size>
                <width>                
                    <xsl:variable name="textWidth" select="//span[contains(@class,'dimensions-group')]//span[contains(@class,'dimension-width')][normalize-space(text())]"/>
                    <xsl:variable name="removeTrash" select="translate($textWidth, 'L', '')"/>
                    <xsl:variable name="removeUnit" select="translate($removeTrash, 'cm', '')"/>
                    <xsl:value-of select="normalize-space($removeUnit)"></xsl:value-of>
                </width>
                <dept>
                    <xsl:variable name="textDept" select="//span[contains(@class,'dimensions-group')]//span[contains(@class,'dimension-dept')][normalize-space(text())]"/>
                    <xsl:variable name="removeTrash" select="translate($textDept, 'W', '')"/>
                    <xsl:variable name="removeUnit" select="translate($removeTrash, 'cm', '')"/>
                    <xsl:value-of select="normalize-space($removeUnit)"></xsl:value-of>
                </dept>
                <height>
                    <xsl:variable name="textHeight" select="//span[contains(@class,'dimensions-group')]//span[contains(@class,'dimension-height')][normalize-space(text())]"/>
                    <xsl:variable name="removeTrash" select="translate($textHeight, 'H', '')"/>
                    <xsl:variable name="removeUnit" select="translate($removeTrash, 'cm', '')"/>
                    <xsl:value-of select="normalize-space($removeUnit)"></xsl:value-of>
                </height>
            </size>
            <material>
                <xsl:value-of select="//div[contains(@class,'material-block')]//span[normalize-space(text())]"></xsl:value-of>
            </material>
        </product>
    </xsl:template>

</xsl:stylesheet>
