<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello Spring Social</title>
    <link href="resources/assets/css/popup_for_twitter.css" rel="stylesheet">
    <!--style>
        *{
            font-family: Areal;
        }
        .b-container{
            width:200px;
            height:150px;
            background-color: #ccc;
            margin:0px auto;
            padding:10px;
            font-size:30px;
            color: #fff;
        }
        .b-popup{
            width:100%;
            height: 2000px;
            background-color: rgba(0,0,0,0.5);
            overflow:hidden;
            position:fixed;
            top:0px;
        }
        .b-popup .b-popup-content{
            margin:40px auto 0px auto;
            width:800px;
            height: 200px;
            padding:10px;
            background-color: #c5c5c5;
            border-radius:5px;
            box-shadow: 0px 0px 10px #000;
        }
    </style-->
</head>
<body>
<div class="b-popup">
    <div class="b-popup-content">
        <h2 align="center">Hello, ${connection.displayName} <img src="${connection.imageUrl}"/></h2>
        <h2 align="center">Please, reenter your Twitter email to create Utility Bills account</h2>
        <form:form method="get" action="/addTwitterUser">
        <h2 align="center">email:
            <input type="text" name="email" value="${email}"/>
            <input type="submit" value="Add">
        </h2>
        </form:form>

    </div>
</div>

</body>
</html>