<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2021
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link href="../css/furama_css.css" rel="stylesheet" type="text/css">
    <link href="../css/base.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <style>
        .nav-link{
            color: black;
            padding-top: 0;
            padding-bottom: 0;
        }
        .dropdown-toggle::after {
            display: inline-block;
            width: 0;
            height: 0;
            content: "";
            border-top: .3em solid;
            border-right: .3em solid transparent;
            border-bottom: 0;
            border-left: .3em solid transparent;
            margin-left: 34px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="row">
        <div class="col-lg-4">
            <img src="../img/logo@2x.png" height="150">
        </div>
        <div class="col-lg-4">
            <img src="../img/logo-chinh-thuc.png" width="100%">
        </div>
        <div class="col-lg-4">
            <form class="form-login">
                <button class="btn btn-outline-success" type="button">Login</button>
                <button class="btn btn-outline-secondary" type="button">Sign up</button>
            </form>
        </div>
    </div>
</div>
<div class="header-link">
    <div class="link-left">
        <ul class="nav__link">
            <li><a href="list.jsp" class="link-control">Home</a></li>
            <li><a href="" class="link-control">Employee</a></li>
            <li><a href="/customer" class="link-control">Customer</a></li>
            <li>    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Service
                    </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/services?action=create&id=1">Villa</a>
                    <a class="dropdown-item" href="/services?action=create&id=2">House</a>
                    <a class="dropdown-item" href="/services?action=create&id=3">Room</a>
                </div></li>
            <li><a href="" class="link-control">Contact</a></li>
        </ul>
    </div>
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" style="margin-top: 0px">
            <input class="form-control mr-sm-2" style="height: 35px" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>



</div>
<div class="container-fluid">
    <div class="row" style="height: 700px">
        <div class="col-sm-6 col-lg-2">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action ">
                    List 1
                </a>
                <a href="#" class="list-group-item list-group-item-action">List 2</a>
                <a href="#" class="list-group-item list-group-item-action">List 3</a>
                <a href="#" class="list-group-item list-group-item-action">List 4</a>
                <a href="#" class="list-group-item list-group-item-action">List 5</a>
                <a href="#" class="list-group-item list-group-item-action">List 6</a>
                <a href="#" class="list-group-item list-group-item-action">List 7</a>
                <a href="#" class="list-group-item list-group-item-action">List 8</a>
                <a href="#" class="list-group-item list-group-item-action">List 9</a>
                <a href="#" class="list-group-item list-group-item-action">List 10</a>
            </div>
        </div>
        <div class="col-sm-6 col-lg-10">
            <div class="row">
                <div class="col-lg-3">
                    <div class="card" style="width: 100%;">
                        <img height="335px" class="card-img-top" src="https://cf.bstatic.com/xdata/images/xphoto/square300/57584488.webp?k=bf724e4e9b9b75480bbe7fc675460a089ba6414fe4693b83ea3fdd8e938832a6&o=" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text" style="font-size: 30px">Khách Sạn</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 100%;">
                        <img height="335px" class="card-img-top" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/card-image-apartments_300/9f60235dc09a3ac3f0a93adbc901c61ecd1ce72e.jpg" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text" style="font-size: 30px">Căn Hộ</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="card" style="width: 100%;">
                        <img height="335px" class="card-img-top" width="300px" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/card-image-villas_300/dd0d7f8202676306a661aa4f0cf1ffab31286211.jpg" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text" style="font-size: 30px">Biệt Thự</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div  class="card" style="width: 100%;">
                        <img height="335px" class="card-img-top" src="https://cf.bstatic.com/static/img/theme-index/carousel_320x240/bg_resorts/6f87c6143fbd51a0bb5d15ca3b9cf84211ab0884.jpg" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text" style="font-size: 30px">Resort</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-2">
                <div class="col-in-row">
                    <div class="picture-service">
                        <img src="../img/300px-Một_biệt_thự_xây_1937.jpg" >
                    </div>
                    <div class="content-picture">
                        <h3>Residencial Sausalito</h3>
                        <span> Gần ga tàu điện ngầm  Gần biển
                            Offering free WiFi and an outdoor pool, Residencial Salsalito is situated in Rio de Janeiro. Copacabana Beach is 1.2 km away. All units are air conditioned and have a cable flat-screen TV.
                            Được đặt 2 lần trong 24 giờ qua
                        </span>
                    </div>
                    <div class="comment" style="padding-left: 50px">
                        <h3>Tuyệt Hảo</h3>
                        <p>311 đánh giá</p>
                        <p>9.0</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="page-footer font-small unique-color-dark" style="font-size: 15px">

    <div style="background-color: #00dc64;">
        <div class="container">


            <div class="row py-4 d-flex align-items-center">


                <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                    <h3 class="mb-0">Get connected with us on social networks!</h3>
                </div>



                <div class="col-md-6 col-lg-7 text-center text-md-right">


                    <a class="fb-ic">
                        <i class="fab fa-facebook-f white-text mr-4"> </i>
                    </a>

                    <a class="tw-ic">
                        <i class="fab fa-twitter white-text mr-4"> </i>
                    </a>

                    <a class="gplus-ic">
                        <i class="fab fa-google-plus-g white-text mr-4"> </i>
                    </a>

                    <a class="li-ic">
                        <i class="fab fa-linkedin-in white-text mr-4"> </i>
                    </a>

                    <a class="ins-ic">
                        <i class="fab fa-instagram white-text"> </i>
                    </a>

                </div>


            </div>


        </div>
    </div>


    <div class="container text-center text-md-left mt-5" >


        <div class="row mt-3">


            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">


                <h4 class="text-uppercase font-weight-bold">Hướng Dẫn Di Chuyển</h4>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám phá một trong những điểm đến hấp dẫn nhất Châu Á. Chỉ cách Đà Nẵng một quãng lái xe ngắn là bốn Di sản Văn hóa Thế giới được UNESCO công nhận:.</p>

            </div>



            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">


                <h4 class="text-uppercase font-weight-bold">Products</h4>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a class="text" href="#!">Hoi An Furama</a>
                </p>
                <p>
                    <a  class="text"href="#!">Nha Trang Furama</a>
                </p>
                <p>
                    <a class="text" href="#!">Phu Quoc Furama</a>
                </p>
                <p>
                    <a  class="text"href="#!">Ho Chi Minh Furama</a>
                </p>

            </div>



            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">


                <h4 class="text-uppercase font-weight-bold">Useful links</h4>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a class="text" href="#!">Your Account</a>
                </p>
                <p>
                    <a class="text" href="#!">Become an Affiliate</a>
                </p>
                <p>
                    <a class="text" href="#!">Shipping Rates</a>
                </p>
                <p>
                    <a class="text" href="#!">Help</a>
                </p>

            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">


                <h4 class="text-uppercase font-weight-bold">Contact</h4>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
                <p>
                    <i class="fas fa-envelope mr-3"></i> info@example.com</p>
                <p>
                    <i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                <p>
                    <i class="fas fa-print mr-3"></i> + 01 234 567 89</p>

            </div>


        </div>


    </div>



    <div class="footer-copyright text-center py-3">© 2020 Copyright:
        <a href="https://mdbootstrap.com/"> Furama.com</a>
    </div>


</footer>

</body>
</html>
