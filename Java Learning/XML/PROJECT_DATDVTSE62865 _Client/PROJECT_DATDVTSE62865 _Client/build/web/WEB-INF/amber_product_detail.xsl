<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : product_detail.xsl
    Created on : July 3, 2020, 8:21 PM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xh="http://www.w3.org/1999/xhtml" version="1.0">
    <xsl:output method="xml" indent="yes" encoding="utf-8"/>

    <!-- TODO customize transformation rules
         syntax recommendation http://www.w3.org/TR/xslt
    -->
    <xsl:template match="/">
        <product>
            <name>
                <xsl:value-of select="//div[@class='product-name']//h1[normalize-space(text())]"/>
            </name>
            <brand>
                <!--<xsl:value-of select="//div[@class='product-cart']//a[normalize-space(text())]"></xsl:value-of>-->
            </brand>
            <price>
                <xsl:variable name="textPrice" select="//div[@class='product-price']//span[normalize-space(text())]"/>
                <xsl:variable name="removedDotPrice" select="translate($textPrice, '.', '')"/>
                <xsl:variable name="removeUnit" select="substring($removedDotPrice, 1, string-length($removedDotPrice) - 4)"/>
                <xsl:variable name="trimPrice" select="normalize-space($removeUnit)"/>
                <xsl:value-of select="$trimPrice"/>
            </price>
            <colors>
                <xsl:for-each select = "//ul[contains(@class,'attribute-squares')]//span/span" >
                    <color>
                        <xsl:variable name="textImage" select="substring(@style,18)"/>
                        <xsl:variable name="textValue" select="substring($textImage,1,string-length($textImage)-21)"/>

                        <xsl:value-of select="$textValue"/>
                    </color>
                </xsl:for-each> 
            </colors>
            <image>
                <xsl:value-of select="//div[contains(@class,'gallery')]//div[contains(@class,'picture-wrapper')]//a/img/@src"/>
            </image>
            <size>
                <xsl:variable name="sizestring" select="translate('K&amp;#xED;ch Th&amp;#x1B0;&amp;#x1EDB;c','abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')" />

                <xsl:variable name="size" select="//dt[translate(label/text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ') = $sizestring]/following-sibling::node()//option[last()][normalize-space(text())]" />
                <width>                
                    <xsl:variable name="getDposition" select="string-length(substring-before($size, 'D'))+1"/>
                    <xsl:variable name="removeD" select="substring($size,$getDposition+1)"/>
                    <xsl:variable name="getDspacePosition" select="string-length(substring-before($removeD, ' '))+1"/>
                    <xsl:variable name="getValueD" select="substring($removeD,1,$getDspacePosition)"/>
                    <xsl:value-of select="translate(normalize-space($getValueD),'cm','')"/>
                    <!--<xsl:value-of select="$size"/>-->
                </width>
                <dept>
                    <xsl:variable name="getRposition" select="string-length(substring-before($size, 'R'))+1"/>
                    <xsl:variable name="removeR" select="substring($size,$getRposition+1)"/>
                    <xsl:variable name="getRspacePosition" select="string-length(substring-before($removeR, ' '))+1"/>
                    <xsl:variable name="getValueR" select="substring($removeR,1,$getRspacePosition)"/>
                    <xsl:value-of select="translate(normalize-space($getValueR),'cm','')"/>

                </dept>
                <height>
                    <xsl:variable name="getCposition" select="string-length(substring-before($size, 'C'))+1"/>
                    <xsl:variable name="removeC" select="substring($size,$getCposition+1)"/>
                    <!--<xsl:variable name="getCspacePosition" select="string-length(substring-before($removeC, ' '))+1==1"/>-->
                    <!--<xsl:variable name="getValueC" select="substring($removeC,1,$getCspacePosition)"/>-->
                    <!--<xsl:value-of select="normalize-space($removeC)"/>-->
                    <xsl:value-of select="translate(normalize-space($removeC),'cm','')"/>

                    
                </height>
            </size>
            <material>
                <xsl:value-of select="//dt[label/text() = 'V&amp;#x1EAD;t li&amp;#x1EC7;u']/following-sibling::node()//option[last()][normalize-space(text())]"/>
            </material>
        </product>
    </xsl:template>

</xsl:stylesheet>
