<?php $title = 'Page de base'; ?>

<?php ob_start();?>
<h1>Titre de page</h1>
<div> Section de la page </div>

<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>