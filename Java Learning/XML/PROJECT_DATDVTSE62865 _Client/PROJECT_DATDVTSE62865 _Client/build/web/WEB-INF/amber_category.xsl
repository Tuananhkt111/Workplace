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
            <xsl:for-each select="//li[contains(@class, 'root-category-items')]//div[contains(@class, 'sublist-wrap categories')]//div[contains(@class, 'title')]/a">
                <category>
                    <name>
                        <xsl:value-of select="span[normalize-space(text())]"></xsl:value-of>
                    </name>
                    <link>
                        <xsl:value-of select="@href"/>
                    </link>
                </category>
            </xsl:for-each>
        </catetories>
    </xsl:template>

</xsl:stylesheet>
