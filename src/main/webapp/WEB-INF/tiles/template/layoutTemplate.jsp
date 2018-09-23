<%--
  Created by IntelliJ IDEA.
  User: Skad1
  Date: 2018-07-17
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><tiles:insertAttribute name="title" /></title>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
            border-right:1px solid #bbb;
        }

        li:last-child {
            border-right: none;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }
        body{
            margin: 0 auto;
        }
        footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #333;
            color: white;
            text-align: center;
        }

        /* form CSS */
        .form{
            background: #f2f2f2;
            border-radius: 5px;
            padding:20px;
            width: 400px;
            margin: 0 auto;
            font-family:"Times New Roman",sans-serif;
            font-size: 16pt;
            margin-top:100px;
        }
        .form input,select{
            width: 100%;
            padding:10px;
            margin:10px 0;
            display: inline-block;
            border:1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
        }
        .form input[type="submit"]{
            background-color: #4CAF50;
            color:#fff;
        }
        .form input[type="submit"]:hover{
            border:1px solid #fff;
            opacity: 0.75;
        }
        .entries{
            font-size:12pt;
        }
        .entries input[type="radio"]{
            width: 5% !important;
        }
        .check{
            font-size:12pt;
        }
        .check input[type="checkbox"]{
            width: 5% !important;
        }
        .registerCss{
            text-align: center;
            background: yellow;
            width: 100%;
            padding: 5px;
            margin: 10px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
            text-decoration: none;
            color: #000;
            font-weight: bold;
        }

       /* Cars */
        .cars {
            margin: 20px;
        }
        .cars > ul {
            list-style-type: none;
            width: 500px;
            background: none;

        }

        .cars > h3 {
            font: bold 20px/1.5 Helvetica, Verdana, sans-serif;
        }

        .cars > ul > li > img {
            float: left;
            margin: 0 15px 0 0;
            width: 170px;
            height: 170px;
        }

        .cars > ul > li > p {
            font: 200 12px/1.5 Georgia, Times New Roman, serif;
        }

        .cars > ul > li {
            padding: 10px;
            overflow: auto;
            background: #eee;
            margin:10px 0;
            border-right: none;
        }
        .cars > ul >li > a{
            float: right;
            background: red;
            border-radius: 30px;
            color:#fff;
        }
    .jumbotron{
        font-size:24px;
        text-align: center;
    }
    </style>
</head>

<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</body>
</html>
