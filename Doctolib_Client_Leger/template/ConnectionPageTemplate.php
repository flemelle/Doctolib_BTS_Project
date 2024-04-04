<?php
$title;
ob_start();
?><div id = "connectionPage">
    <img id ="logo_ConnectionPage" src = "src/Pictures/Logo_Doctolib.svg.png" ></img>
    <form name = 'connectionForm' method = 'post' action = 'index.php' id ='connection_form'>
        <h3>Connexion</h3>
        <input name = 'mail' placeholder = 'adresse mail' type = 'mail'/>
        <input name = 'password' placeholder = 'mot de passe' type = 'password'/>
        <input type = 'submit' name = 'connection'/>
    </form> 
</div>
<?php
$content = ob_get_clean();
require ('LayoutPageTemplate.php');
?>