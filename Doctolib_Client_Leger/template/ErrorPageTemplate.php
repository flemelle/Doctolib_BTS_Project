<?php $title; ?>

<?php ob_start();?>
<h1>ERROR</h1>
<h4><?= $errorType ?></h4>
<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>