<?php $title; ?>

<?php ob_start();?>
<h1>Tableau de bord</h1>
<div> Bienvenue sur la page d'accueil <?= $_SESSION['firstName'] ?> </div>

<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>