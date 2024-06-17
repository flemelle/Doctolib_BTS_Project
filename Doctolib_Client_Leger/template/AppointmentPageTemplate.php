<?php $title;?>

<?php ob_start();?>
<h1>Rendez-vous</h1>
<div> Liste des rendez-vous </div>
<div> 
  <?php if (!empty($data)){
  foreach($data as $Appointment){
    ?>
    <?php if ($Appointment['status'] == "validated"){?>
      <h3>Rendez-vous validés</h3>
                <div>
      <p><?= $Appointment['dateAppointment']?></p>
      <p>Satus : 
            <?php if ($Appointment['status'] == "validated"){?>
                validé
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
            <?php
               }elseif ($Appointment['status'] == "canceled"){?> Annulé
                <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          <?php
          } elseif ($Appointment['status'] == "pending"){?>En attente
              <img class = 'src/Pictures/icons8-horloge-100.png'></img>
          <?php
          }
          ?>
      </p>
      <p>Motif : <?= $Appointment['reason']?></p>
      <p <?= $patientLayout?>>Doctor :<?= $Appointment['doctorFirstName']." ". $Appointment['doctorLastName']?></p>
      <p <?= $doctorLayout?>>Matricule Patient :  <?= $Appointment['idPatient']?></p>
      <?php if ($_SESSION['role'] == "doctor"){?>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm'>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'validated' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
          </button>
      </form>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm'>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'canceled' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          </button>
      </form>
      <?php
          }
          ?>
    </div>
              <?php
               }elseif ($Appointment['status'] == "canceled"){?> 
               <h3>Rendez-vous Annulés</h3>
               <div>
      <p><?= $Appointment['dateAppointment']?></p>
      <p>Satus : 
            <?php if ($Appointment['status'] == "validated"){?>
                validé
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
            <?php
               }elseif ($Appointment['status'] == "canceled"){?> Annulé
                <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          <?php
          } elseif ($Appointment['status'] == "pending"){?>En attente
              <img class = 'src/Pictures/icons8-horloge-100.png'></img>
          <?php
          }
          ?>
      </p>
      <p>Motif : <?= $Appointment['reason']?></p>
      <p <?= $patientLayout?>>Matricule Doctor <?= $Appointment['idDoctor']?></p>
      <p <?= $doctorLayout?>>Matricule Patient :  <?= $Appointment['idPatient']?></p>
      <?php if ($_SESSION['role'] == "doctor"){?>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm' <?= $doctorLayout?>>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'validated' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
          </button>
      </form>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm' <?= $doctorLayout?>>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'canceled' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          </button>
      </form>
      <?php
          }
          ?>
    </div>
          <?php
          } elseif ($Appointment['status'] == "pending"){?>
          <h3>Rendez-vous En attente</h3>
          <div>
      <p><?= $Appointment['dateAppointment']?></p>
      <p>Satus : 
            <?php if ($Appointment['status'] == "validated"){?>
                validé
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
            <?php
               }elseif ($Appointment['status'] == "canceled"){?> Annulé
                <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          <?php
          } elseif ($Appointment['status'] == "pending"){?>En attente
              <img class = 'src/Pictures/icons8-horloge-100.png'></img>
          <?php
          }
          ?>
      </p>
      <p>Motif : <?= $Appointment['reason']?></p>
      <p <?= $patientLayout?>>Matricule Doctor <?= $Appointment['idDoctor']?></p>
      <p <?= $doctorLayout?>>Matricule Patient :  <?= $Appointment['idPatient']?></p>
      <?php if ($_SESSION['role'] == "doctor"){?>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm' <?= $doctorLayout?>>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'validated' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-select-checkmark-symbol-to-choose-true-answer-96.png'></img>
          </button>
      </form>
      <form method ="get" action = "index.php?page=appointment" class ='iconForm' <?= $doctorLayout?>>
          <input type = 'text' name = 'idAppointment' value = <?= $Appointment['idAppointment']; ?> hidden />
          <input type = 'text' name = 'page' value = 'appointment' hidden />
          <input type = 'text' name = 'status' value = 'canceled' hidden />
          <button type="submit" name = 'action' value = 'updateStatus'>
              <img class = 'listImageButton' src ='src/Pictures/icons8-multiplier-96.png'></img>
          </button>
      </form>
      <?php
          }
          ?>
    </div>
          <?php
          }
          ?>
    
  <?php 
  }} else {?>
    <p>Aucun rendez-vous pour le moment</p>
  <?php 
  }?>
  <div <?= $patientLayout?>>
<p>Prendre rendez-vous</p>
<div class ='form'>
  <form class ='form' method = 'post' action ='index.php'>
      <input type = 'text' name = 'idPatient' value ='<?= $_SESSION['idUser']?>' hidden></input>
      <div class = 'formInputDisplay'><label>Date </label><input type = 'date' name = 'dateAppointment'></input></div>
      <div class = 'formInputDisplay'><label>Heure</label> <input type = 'time' name = 'timeAppointment' min="09:00" max="18:00"></input></div>
      <div class = 'formInputDisplay'><label>Matricule de docteur</label><input type = 'text' placeholder = 'Matricule du Docteur' name = 'idDoctor'></input></div>
      <div class = 'formInputDisplay'><label>Motif du rendez-vous</label> <input type = 'text' placeholder = 'Motif du rendez-vous' name ='reason'></input></div>
      <input type = 'submit' name = 'formName' value = 'Confirmer'></input>
  </form>
</div>
</div>
</div>
<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>