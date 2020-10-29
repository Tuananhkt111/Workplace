<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : catetory.xsl
    Created on : July 2, 2020, 8:44 PM
    Author     : Nhung Nguyen
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet version="1.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
>
    <!--<xsl:import href=""-->
    <!--<xsl:import-schema schema-location="import-schema_1.xsd"/>-->
    <xsl:output method="xml"/>
    <!--<xsl:import href="fitin_category.dtd"/>-->
    <xsl:template match="/">
        <categories> 
            <!--            <xsl:attribute name="xmlnsjjj">http://www.w3.org/2001/XMLSchema-instance</xsl:attribute>      
            <xsl:attribute name="xmlns:ns1">http://xml.netbeans.org/schema/categories</xsl:attribute>      
            <xsl:attribute name="xsi:schemaLocation">http://xml.netbeans.org/schema/categories categories.xsd</xsl:attribute>      -->
            <xsl:for-each select="//div[contains(@class, 'tab-collect-content-item')]//h2//a">
                <category>
                    <name>
                        <xsl:value-of select="normalize-space(text())"></xsl:value-of>
                    </name>
                    <link>
                        <xsl:value-of select="@href"/>
                    </link>
                </category>
            </xsl:for-each>
        </categories>
    </xsl:template>

</xsl:stylesheet>
