<?php
$title;
ob_start();?>
<h1>Liste des médecins</h1>

<table>
    <thead>
        <th><a href="index.php?page=doctor&sortBy=lastName">Nom<a></th>
        <th><a href="index.php?page=doctor&sortBy=firstName">Prénom</th>
        <th><a href="index.php?page=doctor&sortBy=mail">Mail</th>
        <th><a href="index.php?page=doctor&sortBy=address">Adresse</th>
        <th colspan ='2'>Edition</th>
    </thead>
    <tbody>   
    <?php foreach ($doctorList as $row){
    ?>  
    <tr>
        <td><?= $row['lastName']; ?></td>
        <td><?= $row['firstName']; ?></td>
        <td><?= $row['mail']; ?></td>
        <td><?= $row['address']; ?></td>
        <td>
            <form method ="get" action = "index.php?page=doctor" class ='iconForm'>
                <input type = 'text' name = 'idUser' value = <?= $row['idUser']; ?> hidden />
                <input type = 'text' name = 'page' value = 'doctor' hidden />
                <button type="submit" name = 'action' value = 'delete'>
                    <img class = 'listImageButton' src ='src/Pictures/icons8-bin-128.png'></img>
                </button>
            </form>
        </td>
        <td>
            <form method ="get" action = "index.php?page=doctor" class ='iconForm'>
                <input type = 'text' name = 'idUser' value = <?= $row['idUser']; ?> hidden />
                <input type = 'text' name = 'page' value = 'doctor' hidden />
                <button type="submit" name = 'action' value = 'update'>
                    <img class = 'listImageButton' src ='src/Pictures/icons8-pencil-96.png'></img>
                </button>
            </form>
        </td>
    </tr>
    <?php
    } ?>
    </tbody>
</table>
<?php
$content = ob_get_clean();
require 'LayoutPageTemplate.php';
?>