<?php $title?>

<?php ob_start();?>
<h1>Ordonnance</h1>
<div <?= $patientLayout?>> 
  <?php if (!empty($data)){
  foreach($data as $prescription){
    ?>
    <div class ='prescription'>
      <p>Ordonnance délivrée par le Docteur <?= $prescription["idDoctor"]?>, délivrée le <?= $prescription["datePrescription"]?> </p>
      <p> Au nom de <?= $prescription["firstName"]?> <?= $prescription["lastName"]?></p>
      <p><?= $prescription["content"]?></p>
    </div>
  <?php 
  }} else {?>
    <p>Aucune ordonnace pour le moment</p>
  <?php 
  }?>
</div>
<div <?= $doctorLayout?>>
<p>Créer une nouvelle ordonnance</p>
<div class ='form'>
  <form class ='form' method = 'post' action ='index.php'>
      <input type ="text" name = "idDoctor" value ="<?= $_SESSION["idUser"]?>" hidden></input>
      <div class = 'formInputDisplay'><label> Date de l'ordonnace</label> <input type ="text" name = "datePrescription" value ="<?= date("Y-m-d")?>" disabled></input></div>
      <div class = 'formInputDisplay'><label> Matricule du patient</label> <input type ="text" placeholder = "Matricule du patient" name = "idPatient"></input></div>
      <div class = 'formInputDisplay'><label> Contenue de l'ordonnace</label><input type = 'text' placeholder = "Contenue de l'ordonnace" name ='content'></input></div>
      <input type = 'submit' name = 'formName' value = 'Valider'></input></div>
  </form>
</div>
</div>
<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>

