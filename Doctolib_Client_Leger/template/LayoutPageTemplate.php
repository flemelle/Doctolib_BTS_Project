<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8"/>
        <link rel ='icon' type = 'img/x-icon' href = 'src/Pictures/icon-doctolib.png'> 
        <title><?= $title ?></title>
        <link rel ="stylesheet" href = style.css>
    </head>
    <body>
        <?php
        if (isset($_SESSION['connected'])){
            if ($_SESSION['connected'] == 'on'){
                include 'header.php';
            }
        }
        ?>
        <div id = "mainContainer"><?= $content;?></div>
        <?php
        include 'footer.php';
        ?>
    </body>
</html>