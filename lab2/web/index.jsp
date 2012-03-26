<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ChartModel" %>
<%@ page import="static model.ShapeUtil.getLab2Shape" %>

<html >
<script type="text/javascript">
    var isXValid=false;
    var isYValid=false;
    var isRValid=false;

    var R;

    function onRButtonClick(e) {
        document.getElementById("r").value =  document.getElementById(e).value;
        if (document.getElementById(e).value > 0) {
            R = document.getElementById(e).value;
            isRValid = true;

            if (isXValid && isYValid && isRValid) {
                enableSubmit();
            }
        } else {
            isRValid=false;
            disableSubmit()
        }
    }

    function onXButtonClick(e) {
        var newValue = document.getElementById(e).value;
        document.getElementById("x").value =  newValue;

        if (newValue.match(/^-?\d+([.|,]\d+)?$/)) {
            isXValid=true;
            if (isXValid && isYValid && isRValid) {
                enableSubmit();
            }
        } else {
            isXValid=false;
            disableSubmit();

        }
    }

    function onYChange(e) {
        if (e.match(/^-?\d+([.|,]\d+)?$/) && e > -3 && e < 5) {
            isYValid=true;
            if (isXValid && isYValid && isRValid) {
                enableSubmit();
            }
        } else {
            isYValid=false;
            disableSubmit();
        }
    }


    function enableSubmit() {
        document.getElementById("submit").disabled = false;
    }

    function disableSubmit() {
        document.getElementById("submit").disabled = true;
    }

    function getPoint(event) {
        if (!isRValid)
            alert("Please set Radius first!");
        else {
            var pos_x = event.offsetX?(event.offsetX):event.pageX-document.getElementById("pointer-div").offsetLeft;
            var pos_y = event.offsetY?(event.offsetY):event.pageY-document.getElementById("pointer-div").offsetTop;
            pos_x = pos_x * R * 2 / 170 - R;
            pos_y = R - pos_y * R * 2 / 168;
            document.pointform.form_x.value = pos_x;
            document.pointform.form_y.value = pos_y;
            isXValid=true;
            isYValid=true;
            if (isXValid && isYValid  && isRValid)
                enableSubmit();
            document.enterform.x.value = pos_x;
            document.enterform.y.value = pos_y;

        }
    }



</script>
<head>
    <title>Lab 6</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    Lab 6, Shamukov A. & Dymov E. at 4100
</head>
<body>
<p>Is point inside figure?</p>
<form method="GET" action="/lab2_war_exploded/" enctype="multipart/form-data" name="enterform">
    <table id="input-table">
        <tr>
            <td class="first-td">
                x:
            </td>
            <td>

                <input type=text name="x" id="x"  size=5 onkeypress="return event.keyCode!=13" readonly="true"  >
            </td>
            <td>

                <input type="button" value="-2" id="x1" onclick="onXButtonClick(this.id)">
                <input type="button" value="-1.5" id="x2" onclick="onXButtonClick(this.id)">
                <input type="button" value="-1" id="x3" onclick="onXButtonClick(this.id)">
                <input type="button" value="-0.5" id="x4" onclick="onXButtonClick(this.id)">
                <input type="button" value="0" id="x5" onclick="onXButtonClick(this.id)">
                <input type="button" value="0.5" id="x6" onclick="onXButtonClick(this.id)">
                <input type="button" value="1" id="x7" onclick="onXButtonClick(this.id)">
                <input type="button" value="1.5" id="x8" onclick="onXButtonClick(this.id)">
                <input type="button" value="2" id="x9" onclick="onXButtonClick(this.id)">
            </td>
        </tr>
        <tr>
            <td class="first-td">
                y:
            </td>
            <td>
                <input type=text name="y"  size=5 onkeypress="return event.keyCode!=13" onchange="onYChange(this.value)">
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td class="first-td">
                r:
            </td>
            <td>
                <input type=text name="r" id="r"  size=5 onkeypress="return event.keyCode!=13" readonly="true"  >
            </td>
            <td>
                <input type="button" value="1" id="r1" onclick="onRButtonClick(this.id)">
                <input type="button" value="1.5" id="r2" onclick="onRButtonClick(this.id)">
                <input type="button" value="2" id="r3" onclick="onRButtonClick(this.id)">
                <input type="button" value="2.5" id="r4" onclick="onRButtonClick(this.id)">
                <input type="button" value="3" id="r5" onclick="onRButtonClick(this.id)">

            </td>
        </tr>
        <tr>
            <td colspan="3">
                <br/>
                <input type=submit value="Send data to server" id="submit" disabled="true">
            </td>
        </tr>
    </table>
</form>


<form name="pointform" method="post">
    <div id="pointer-div" onclick="getPoint(event)"></div>

    <p>
        You clicked at:
        <br>
        <input type="text" name="form_x" size="4" readonly="true" />
        <input type="text" name="form_y" size="4" readonly="true" />
    </p>
</form>

<table id="res-table" border="2px">
    <%= processRequestAndGetLog(request, out) %>
</table>


</body>
</html>

<%!
    private final StringBuilder resultLog = new StringBuilder();

    public String formatData(float x, float y, float r, boolean isContains) {
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                String.valueOf(x),
                String.valueOf(y),
                String.valueOf(r),
                String.valueOf(isContains));
    }

    private String processRequestAndGetLog(final HttpServletRequest request, final JspWriter out) {
        try {
            if (request != null) {
                final ChartModel chartModel = new ChartModel(getLab2Shape());
                final float x = Float.valueOf(request.getParameter("x"));
                final float y = Float.valueOf(request.getParameter("y"));
                final float r = Float.valueOf(request.getParameter("r"));
                chartModel.setCurrentX(x);
                chartModel.setCurrentY(y);
                chartModel.setRadius(r);
                final boolean containsLiteral = chartModel.containsCurrentPosition();

                resultLog.append(formatData(x, y, r, containsLiteral));
            }
        } catch (final NullPointerException e) {
            //Do nothing
        }
        return resultLog.toString();
    }
%>