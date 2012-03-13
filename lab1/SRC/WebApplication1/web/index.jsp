<%-- 
    Document   : index
    Created on : 13.03.2012, 17:10:38
    Author     : eugene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <title>Lab.1</title>
        <link href="style.css" rel="stylesheet" type="text/css">
        <script language="javascript">
            function validateForm() {
                var y = document.forms["labForm"]["y"].value;
                
                if (y.match(/^-?\d+[\.|\,]?\d+$/)) {
                    return true;
                }
                
                if (y.match(/^-?\d$/)) {
                    return true;
                }
        
                if (y.match(/^-?\d+e-?\d+$/)) {
                    return true;
                }
                
                if (y < -3 || y > 5) {
                    document.getElementById("error").innerHTML="Out of range!"; 
                    return false;
                }
				
                document.getElementById("error").innerHTML="Incorrect data!"; 
                return false;
            }
        </script>
    </head>
    <body>        
        <form name="labForm" action="Servlet" method="GET" onsubmit="return validateForm();">
            <table id="mainTable" rules=all>
                <tr>
                    <td colspan="2">Lab1.Dymov &amp; Shamukov.4100</td>
                </tr>
                <tr>
                    <td colspan="2"><div id="variant">Variant 148/GET</div></td>
                </tr>
                <tr>
                    <td id="titleRows">X</td>
                    <td>  
                        <table id="insideTable">
                            <tr>
                                <td id="hoverable"><input id="x0" type="radio" name="x" value="-2" CHECKED/> 
                                    <label>-2 </label></td>
                                <td id="hoverable"><input id="x1" type="radio" name="x" value="-1.5"/>
                                    <label>-1.5</label>  </td>
                                <td id="hoverable"><input id="x2" type="radio" name="x" value="-1"/> 
                                    <label>-1</label></td>
                            </tr>
                            <tr>
                                <td id="hoverable"><input id="x3" type="radio" name="x" value="-0.5"/> 
                                    <label>-0.5</label> </td>
                                <td id="hoverable"><input id="x4" type="radio" name="x" value="0"/> 
                                    <label>0</label>    </td>     
                                <td id="hoverable"><input id="x5" type="radio" name="x" value="0.5"/> 
                                    <label>0.5</label> </td>
                            </tr>
                            <tr>
                                <td id="hoverable"><input id="x6" type="radio" name="x" value="1"/> 
                                    <label>1</label>   </td> 
                                <td id="hoverable"><input id="x7" type="radio" name="x" value="1.5"/> 
                                    <label>1.5</label></td>
                                <td id="hoverable"><input id="x8" type="radio" name="x" value="2"/>
                                    <label>2</label></td>
                            </tr>
                        </table>
                </tr>
                <tr>
                    <td id="titleRows">Y</td><td id="hoverable"><input id="inputY" type="text" name="y" value="0.0"/></td>
                </tr>
                <tr height=50>
                    <td id="titleRows">R</td>
                    <td>
                        <table  id="insideTable">
                            <tr>
                                <td id="hoverable"><input id="r0" type="radio" name="r" value="1" CHECKED/> 
                                    <label>1 </label></td>
                                <td id="hoverable"><input id="r1" type="radio" name="r" value="1.5"/>
                                    <label>1.5</label>  </td>
                                <td id="hoverable"><input id="r2" type="radio" name="r" value="2"/> 
                                    <label>2</label></td>
                            </tr>
                            <tr>
                                <td id="hoverable"><input id="r3" type="radio" name="r" value="2.5"/> 
                                    <label>2.5</label> </td>
                                <td id="hoverable"><input id="r4" type="radio" name="r" value="3"/> 
                                    <label>3</label>    </td>     
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td id="confirmCell" colspan=2><input id="confirmButton" type="submit" value="Confirm"></td>
                </tr>
                <tr>
                    <td colspan=2><div id="error"></div></td>
                </tr>
            </table>
        </form>
    </body>
</html>
