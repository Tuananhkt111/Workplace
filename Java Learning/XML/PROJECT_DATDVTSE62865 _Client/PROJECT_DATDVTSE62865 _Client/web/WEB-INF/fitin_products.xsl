<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : catetory.xsl
    Created on : July 2, 2020, 8:44 PM
    Author     : Nhung Nguyen
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <catetories>
            <numberpage>
                <xsl:value-of select="//div[contains(@class,'pagination-bar')]//li[last()]//a[normalize-space(text())]"></xsl:value-of>
            </numberpage>
            <list>
                <xsl:for-each select="//div[contains(@class, 'product-list')]//div[contains(@class,'col-lg-12 col-md-12 col-sm-12 col-xs-12')]//a">
                    <category>
                        <name>
                            <xsl:value-of select="normalize-space(text())"></xsl:value-of>
                        </name>
                        <link>
                            <xsl:value-of select="@href"/>
                        </link>
                    </category>
                </xsl:for-each>
            </list>
        </catetories>
    </xsl:template>

</xsl:stylesheet>
