<?php $title?>

<?php ob_start();?>
<h1>Information du compte</h1>
<div class ='form' > 
    <form method ="post" action ="index.php">
        <input type ="text" name = "idUser" value ="<?= $data["idUser"]?>" hidden></input>
        <div class = 'formInputDisplay'><label>Prénom</label><input type ="text" placeholder = "Prénom" name = "firstName" value ="<?= $data["firstName"]?>" <?= $this -> editInput ?>></input></div>
        <div class = 'formInputDisplay'><label>Nom</label><input type ="text" placeholder = "Nom" name = "lastName" value ="<?= $data["lastName"]?>" <?= $this -> editInput ?>></input></div>
        <div class = 'formInputDisplay'><label>Âge</label><input type ="text" placeholder = "Âge" name = "age" value ="<?= $data["age"]?>" <?= $this -> editInput ?>></input></div>
        <div class = 'formInputDisplay'><label>Adresse mail</label><input type ="mail" placeholder = "Adresse mail" name = "mail" value ="<?= $data["mail"]?>" <?= $this -> editInput ?>></input></div>
        <div class = 'formInputDisplay'><label>Adresse postale</label><input type ="text" placeholder = "Adresse postale" name = "address" value ="<?= $data["address"]?>" <?= $this -> editInput ?>></input></div>
        <div class = 'formInputDisplay'><label>Rôle</label><input type ="text" placeholder = "Rôle" name = "role" value ="<?= $data["role"]?>" disabled></input></div>
        <div><input type ="submit" value ="Sauvegarder" name = "formName" <?= $this -> submitHidden ?>></input></div>
    </form>
    <button <?= $this -> mofidyButton ?> onclick="window.location.href='index.php?page=account&action=update'">Modifier</button> 
</div>

<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>