<%--
  Created by IntelliJ IDEA.
  User: sunilkumar
  Date: 02/08/13
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
    <meta name="layout" content="main"/>

    <script type="text/javascript">

        var keyToType;
        var typeToOperations;

        function load_data(){
            keyToType = <%= keysToType.toString() %>;
            typeToOperations = <%= typeToOperations.toString() %>;
            load_valid_operators(document.getElementById("attribute"))
        }

        function load_valid_operators(elem){
            var selectedKey = elem.options[elem.selectedIndex].value;
            var type = keyToType[selectedKey];
            var values = typeToOperations[type];

            var element = document.getElementById("operators");
            for ( var i = 0 ; i < values.length; i++ ){
                element.options[element.options.length] = new Option(values[i], values[i]);
            }
        }
        window.onload = load_data
    </script>
</head>
<body>
<div>
<table class="table table-bordered table-striped row row-fluid">
    <thead>
    <tr>
        <th>Attribute</th>
        <th>Operator</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><g:select name="attributes" id="attribute" from="${com.flipkart.hackathon.easyhire.FilterUtils.getValidKeys()}" onChange="load_valid_operators(this)"></g:select></td>
            <td><g:select name="operators" id="operators" from=""></g:select></td>
            <td><g:textField name="values" id="values" placeholder="Enter Value"></g:textField></td>
        </tr>
    </tbody>
</table>
</div>
</body>
</html>