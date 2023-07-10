<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        h1, h2, h3, h4, h5, h6 {
            font-family: "Oswald"
        }

        body {
            font-family: "Times New Roman"
        }

    </style>
</head>
<body class="w3-light-grey container">

<!-- Navigation bar with social media icons -->
<div class="w3-bar w3-black w3-hide-small">
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-facebook-official"></i></a>
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-instagram"></i></a>
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-snapchat"></i></a>
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-flickr"></i></a>
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-twitter"></i></a>
    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-linkedin"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-right"><i class="fa fa-search"></i></a>
</div>

<!-- w3-content defines a container for fixed size centered content,
and is wrapped around the whole page content, except for the footer in this example -->
<div>
    <div style="float:left;width:20%; position: fixed;left: 11.1%">
        <!-- About/Information menu -->
        <div>
            <div class="w3-white w3-margin">
                <div class="w3-container w3-padding w3-black">
                    <h4>Menu</h4>
                </div>
                <ul class="w3-ul w3-hoverable w3-white">
                    <li class="w3-padding-16">
                        <i class="fa fa-plus" style="font-size:24px;color: green"></i>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <a href="/create" class="w3-large text-success">More post</a>
                        <br>
                    </li>
                    <li>
                    <i class="fa fa-trash-o" style="font-size:24px;color:red"></i>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <a href="/historyDelete" class="w3-large text-success">Deleted post</a>
                        <br>
                    </li>
                    <li class="w3-padding-16">
                        <i class="fa fa-arrow-circle-left" style="font-size:24px"></i>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <a href="/index" class="w3-large text-success">Exit</a>
                        <br>
                    </li>
                </ul>
            </div>
            <hr>

            <div class="w3-white w3-margin">
                <div class="w3-container w3-padding w3-black">
                    <h4>Follow Me</h4>
                </div>
                <div class="w3-container w3-xlarge w3-padding">
                    <i class="fa fa-facebook-official w3-hover-opacity"></i>
                    <i class="fa fa-instagram w3-hover-opacity"></i>
                    <i class="fa fa-snapchat w3-hover-opacity"></i>
                    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
                    <i class="fa fa-twitter w3-hover-opacity"></i>
                    <i class="fa fa-linkedin w3-hover-opacity"></i>
                </div>
            </div>
            <hr>

            <!-- Subscribe -->
            <div class="w3-white w3-margin">
                <div class="w3-container w3-padding w3-black">
                    <h4>Subscribe</h4>
                </div>
                <div class="w3-container w3-white">
                    <p>Enter your e-mail below and get notified on the latest blog posts.</p>
                    <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail" style="width:100%">
                    </p>
                    <p>
                        <button type="button" onclick="document.getElementById('subscribe').style.display='block'"
                                class="w3-button w3-block w3-red">Subscribe
                        </button>
                    </p>
                </div>
            </div>
            <!-- END About/Intro Menu -->
        </div>
    </div>
    <div style="float: left;width: 57%;position: absolute; left:31%">
        <div>
            <div class="w3-container w3-white w3-padding-large">
                <div class="w3-center">
                    <h3>${post.title}</h3>
                    <h5>Creation Time <span class="w3-opacity">${post.creationTimeString()}</span></h5>
                </div>
                <div class="w3-justify">
                    <img src="${post.image}" alt="Image "
                         style="width:100%;height:350px"
                         class="w3-padding-16">
                    <p>${post.content}</p>
                    <p class="w3-clear"></p>
                    <div class="w3-row w3-margin-bottom" id="demo1" style="display:none">
                        <hr>
                        <div class="w3-col l2 m3">
                            <img src="/w3images/avatar_smoke.jpg" style="width:90px;">
                        </div>
                        <div class="w3-col l10 m9">
                            <h4>George <span class="w3-opacity w3-medium">May 3, 2015, 6:32 PM</span></h4>
                            <p>Great blog post! Following</p>
                        </div>
                    </div>
                </div>
                <a href="/edit?idPost=${post.idPost}" type="button" class="btn btn-success">Edit</a>
                <a href="/delete?idPost=${post.idPost}" type="button" class="btn btn-danger">Delete</a>
                <br>
                <hr>
                <br>
            </div>
            <hr>
        </div>
    </div>
</div>


<!-- Subscribe Modal -->
<div id="subscribe" class="w3-modal w3-animate-opacity">
    <div class="w3-modal-content" style="padding:32px">
        <div class="w3-container w3-white">
            <i onclick="document.getElementById('subscribe').style.display='none'"
               class="fa fa-remove w3-transparent w3-button w3-xlarge w3-right"></i>
            <h2 class="w3-wide">SUBSCRIBE</h2>
            <p>Join my mailing list to receive updates on the latest blog posts and other things.</p>
            <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail"></p>
            <button type="button" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom"
                    onclick="document.getElementById('subscribe').style.display='none'">Subscribe
            </button>
        </div>
    </div>
</div>
</body>
</html>


<script>
    // Toggle between hiding and showing blog replies/comments
    document.getElementById("myBtn").click();

    function myFunction(id) {
        let x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }

    function likeFunction(x) {
        x.style.fontWeight = "bold";
        x.innerHTML = "✓ Liked";
    }
</script>