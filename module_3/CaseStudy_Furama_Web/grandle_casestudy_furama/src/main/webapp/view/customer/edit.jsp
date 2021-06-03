<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link href="../../css/base.css" rel="stylesheet" type="text/css">
    <link href="../../css/furama_css.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <style>
        body {
            margin: 0;
            /*padding-top: 40px;*/
            color: #2e323c;
            background: #f5f6fa;
            position: relative;
            height: 100%;
        }
        label{
            font-size: 20px;
        }
        .row__start{
            text-align: start;
        }
        .account-settings .user-profile {
            margin: 0 0 1rem 0;
            padding-bottom: 1rem;
            text-align: center;
        }
        .account-settings .user-profile .user-avatar {
            margin: 0 0 1rem 0;
        }
        .account-settings .user-profile .user-avatar img {
            width: 90px;
            height: 90px;
            -webkit-border-radius: 100px;
            -moz-border-radius: 100px;
            border-radius: 100px;
        }
        .account-settings .user-profile h5.user-name {
            margin: 0 0 0.5rem 0;
        }
        .account-settings .user-profile h6.user-email {
            margin: 0;
            font-size: 3rem;
            font-weight: 400;
            color: #9fa8b9;
        }
        .account-settings .about {
            margin: 2rem 0 0 0;
            text-align: center;
        }
        .account-settings .about h5 {
            margin: 0 0 15px 0;
            color: #007ae1;
        }
        .account-settings .about p {
            font-size: 1rem;
        }
        .form-control {
            border: 1px solid #cfd1d8;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border-radius: 2px;
            font-size: 2rem;
            background: #ffffff;
            color: #2e323c;
        }

        .card {
            background: #ffffff;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            border: 0;
            margin-bottom: 1rem;
        }

    </style>
</head>
<body>
<div class="header">
    <div class="row">
        <div class="col-lg-4">
            <img src="../../img/logo@2x.png" height="150">
        </div>
        <div class="col-lg-4">
            <img src="../../img//logo-chinh-thuc.png" width="100%">
        </div>
        <div class="col-lg-4">
            <form class="form-login">
                <button class="btn btn-outline-success" type="button">Login</button>
                <button class="btn btn-outline-secondary" type="button">Sign up</button>
            </form>
        </div>
    </div>
</div>

<div class="container mt-5">
    <div class="row gutters row__start">
        <div class="col-xl-12">
            <h1>
                Edit Customers
            </h1>
        </div>
        <div class="col-xl-12 col-lg-9 col-md-12 col-sm-12 col-12">
            <div class="card h-100">
                <form method="post">
                    <div class="card-body">
                        <div class="row gutters row__start">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <h3 class="mb-2 text-primary">Customers Details</h3>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <c:if test="${customers != null}">
                                    <input type="hidden" name="customers_id" value="${customers.customer_id}"/>
                                </c:if>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                            <div class="form-group">
                                <label >Customer Type</label>
                                <select class="custom-select" id="inputGroupSelect01" name="customer_type_id" style="font-size: 2rem;height: 40px">
                                    <option value="1"
                                        <c:if test="${customers.customerType_id.customerTypeId == 1}">
                                            selected
                                        </c:if>
                                    >Diamond</option>
                                    <option value="2"
                                            <c:if test="${customers.customerType_id.customerTypeId == 2}">
                                                selected
                                            </c:if>>Platinium</option>
                                    <option value="3"
                                            <c:if test="${customers.customerType_id.customerTypeId == 3}">
                                                selected
                                            </c:if>>Gold</option>
                                    <option value="4"
                                            <c:if test="${customers.customerType_id.customerTypeId == 4}">
                                                selected
                                            </c:if>>Silver</option>
                                    <option value="5"
                                            <c:if test="${customers.customerType_id.customerTypeId == 5}">
                                                selected
                                            </c:if>>Member</option>
                                </select>
                            </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">

                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="customer_name" value="${customers.customer_name}" type="text" class="form-control"  placeholder="Name">
                                </div>
                            </div>

                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label >Day Of Birth</label>
                                    <input  value="${customers.customer_birthday}" name="customer_birthday" type="text" class="form-control"  placeholder="Enter Day Of Birth">
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label >Customer Type</label>
                                    <select class="custom-select" id="inputGroupSelect02" name="customer_gender" style="font-size: 2rem;height: 40px">
                                        <option value="Male" <c:if test="${customers.customer_gender == 'Male'}">
                                                selected
                                            </c:if> >Male</option>
                                        <option value="Famale"
                                                <c:if test="${customers.customer_gender == 'Famale'}">
                                                    selected
                                                </c:if> >Famale</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>ID Card</label>
                                    <input value="${customers.customer_id_card}" name="customer_id_card" type="text" class="form-control"  placeholder="ID Card">
                                </div>
                            </div>
                        </div>
                        <div class="row gutters row__start">
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input value="${customers.customer_phone}" name="customer_phone" type="text" class="form-control"  placeholder="Phone">
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input value="${customers.customer_email}" name="customer_email" type="text" class="form-control"  placeholder="Enter Email">
                                </div>
                            </div>
                            <div class="col-xl-12 col-lg-6 col-md-6 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Address</label>
                                    <input value="${customers.customer_address}" name="customer_address" type="text" class="form-control" placeholder="Enter Address">
                                </div>
                            </div>
                        </div>
                        <div class="row gutters row__start">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                <div class="text-center">
                                    <a type="button" href="customer?action=customers" class="btn btn-outline-secondary">Close</a>
                                    <input type="submit" value="Save" class="btn btn-outline-success"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

