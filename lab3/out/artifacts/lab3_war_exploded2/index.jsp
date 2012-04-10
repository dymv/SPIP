<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"  %>

<html>
<script type="text/javascript">

    function draw() {
        var c=document.getElementById("myCanvas");
        var cxt=c.getContext("2d");
        var img=new Image();
        img.src="model.png";
        cxt.drawImage(img,0,0);
    }


    function getColor( event) {
        var canvas=document.getElementById("myCanvas");
        var x = event.offsetX?(event.offsetX):event.pageX-canvas.offsetLeft;
        var y = event.offsetY?(event.offsetY):event.pageY-canvas.offsetTop;
        var cxt=canvas.getContext("2d")
        var data = cxt.getImageData(x, y, 1, 1);
        alert(data.data[1])   ;

        var data1 = cxt.getImageData(x, y, 25,25 );

        if (data.data[1]!=255 && data.data[1]!=0 && data.data[1]!=254 ) {
            data1.data[0]=66;
            data1.data[1] = 66;
            data1.data[2]=66;
        } else {
            data1.data[0] = 240;
            data1.data[1] = 12;
            data1.data[2]=69;
        }

        cxt.putImageData(data1,x-1, y-1);
        cxt.putImageData(data1,x-1, y);
        cxt.putImageData(data1,x-1, y+1);

        cxt.putImageData(data1,x, y);
        cxt.putImageData(data1,x, y-1);
        cxt.putImageData(data1,x, y+1);

        cxt.putImageData(data1,x+1, y+1);
        cxt.putImageData(data1,x+1, y);
        cxt.putImageData(data1,x+1, y-1);

    }

</script>

<head>
    <title>LabWork №6.</title>
    <style type="text/css">
        body {
            font-family: verdana, tahoma, sans-serif;
            color: #333366;
            text-align: center;
            margin-top: 50px;
        }
    </style>
    <p style="vertical-align:top"> LabWork №7, Done by Soleev A. and Dyuzheva E.    </p>
</head>

<body onload="draw()">
<canvas id="myCanvas" onclick="getColor(event)" width="161" height="158" style="border:1px solid #c3c3c3;"/>
<f:view >
    <div id="content" align="center">
        <h:form id="SendToJSP">
            <table>
                <tr>
                    <td><h:outputLabel value="Xchord:" for="x" /></td>
                    <td>
                        <h:commandLink value="-3" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="-3" />
                        </h:commandLink>

                        <h:commandLink value="-2" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="-2" />
                        </h:commandLink>

                        <h:commandLink value="-1" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="-1" />
                        </h:commandLink>

                        <h:commandLink value="0" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="0" />
                        </h:commandLink>

                        <h:commandLink value="1" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="1" />
                        </h:commandLink>

                        <h:commandLink value="2" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="2" />
                        </h:commandLink>

                        <h:commandLink value="3" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="3" />
                        </h:commandLink>

                        <h:commandLink value="4" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="4" />
                        </h:commandLink>

                        <h:commandLink value="5" style="margin-left:5px" action="#{pointInfo.xCommandLinkClicked}">
                            <f:param name="x" value="5" />
                        </h:commandLink>

                        <h:inputText id="x"   style="margin-left:15px"
                                     value="#{pointInfo.x}" required="true" size = "5" >

                            <f:validateDoubleRange minimum="-3" maximum="5"/>
                        </h:inputText>
                    </td>

                    <td><h:message for="x" /></td>
                </tr>

                <tr>
                    <td><h:outputLabel value="Ychord:" for="y" /></td>
                    <td><h:inputText id="y"
                                     value="#{pointInfo.y}" required="true" size = "5" >

                        <f:validateDoubleRange minimum="-3" maximum="5"/>
                        <!--f:validateRegex pattern="^-?[0-9]+.{0,1}[0-9]*$" /-->
                    </h:inputText>
                    </td>
                    <td><h:message for="y" /></td>
                </tr>

                <tr>
                    <td><h:outputLabel value="R:" for="R" /></td>
                    <td><h:selectOneMenu id="R"
                                         value="#{pointInfo.r}" required="true">
                        <f:selectItem itemLabel="1" itemValue="1" />
                        <f:selectItem itemLabel="2" itemValue="2" />
                        <f:selectItem itemLabel="3" itemValue="3" />
                        <f:selectItem itemLabel="4" itemValue="4" />
                        <f:selectItem itemLabel="5" itemValue="5" />
                    </h:selectOneMenu>
                    </td>
                    <td><h:message for="R" /></td>

                </tr>
            </table>
            <h:commandButton action="#{pointInfo.addPoint}"  value="Send data to server"/>
        </h:form>
        <div id="tablefield">
            <h:panelGroup rendered = "#{true}">
                <div id="graphfield">
                    <f:verbatim escape="false">
                        <applet code="Graph.class" width="329" height="210" >
                            <blockquote>
                                <hr>
                                If you were using a Java-capable browser,
                                youwould see Applet3D instead of this paragraph.
                                <hr>
                            </blockquote>
                            <param name="X" value="${pointInfo.x}">
                            <param name="Y" value="${pointInfo.y}">
                            <param name="R" value="${pointInfo.r}">
                            <param name="in" value="${pointInfo.containes}">
                        </applet>
                    </f:verbatim>
                </div>
                <br >
                <h:dataTable id="dt1" value="#{pointInfo.points}" var="point" border="5" cellpadding="5" cellspacing="3" first="0" width="50%" dir="LTR" frame="hsides"  rules="all"  >

                    <f:facet name="header">
                        <h:outputText value="Results table" />
                    </f:facet>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="X" />
                        </f:facet>
                        <h:outputText value="#{point.x}"></h:outputText>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Y"/>
                        </f:facet>
                        <h:outputText value="#{point.y}"></h:outputText>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="R"/>
                        </f:facet>
                        <h:outputText value="#{point.r}"></h:outputText>
                    </h:column>

                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="IsContaines"/>
                        </f:facet>
                        <h:outputText value="#{point.isContaines}"></h:outputText>
                    </h:column>


                </h:dataTable>
                <br>
                <br>

            </h:panelGroup>
        </div>
    </div>
</f:view>

</body>
</html>


