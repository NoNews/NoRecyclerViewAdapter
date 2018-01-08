<?xml version="1.0"?>
<recipe>

    <!-- Копирование с использованием Freemarker (откуда/куда) * -->
    <instantiate from="layout/item.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(adapterItemLayoutName)}.xml" />

     <!-- После копирования, файл будет открыт в Android Studio-->
     <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(adapterItemLayoutName)}.xml" />



    <!-- Копирование с использованием Freemarker (откуда/куда) * -->
    <instantiate from="jvm/RecyclerViewAdapter.java.ftl"
                 to="${escapeXmlAttribute(srcOut)}/adapters/${adapterClassName}.java"/>


    <!-- После копирования, файл будет открыт в Android Studio-->
    <open file="${escapeXmlAttribute(srcOut)}/adapters/${adapterClassName}.java"/>


    <!-- Будет подключён дополнительный модуль через implementation в Android Studio 3.0
                                           или через compile в Android Studio 2+ -->
     <#if isDependencyNeeded>
     <dependency mavenUrl="com.android.support:recyclerview-v7:26.1.0"/>
     </#if>

</recipe>
