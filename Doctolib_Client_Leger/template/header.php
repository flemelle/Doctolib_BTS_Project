<header>
<a href="index.php?page=homePage">
    <img id ="logo_header" src = "src/Pictures/images.png" ></img>
</a>
    <ul><li>
            <a href="index.php?page=homePage">Accueil</a>
        </li>
        <?php if ($_SESSION['role'] != 'admin'){?>
        <li>
            <a href="index.php?page=appointment">Rendez-vous</a>
        </li>
        <?php }?>
        <?php if ($_SESSION['role'] == 'admin'){?>
        <li>
            <a href="index.php?page=doctor">Médecins</a>
        </li>
        <li>
            <a href="index.php?page=patient">Patients</a>
        </li>
        <?php }?>
        <?php if ($_SESSION['role'] != 'admin'){?>
        <li>
            <a href="index.php?page=prescription">Ordonnances</a>
        </li>
        <?php }?>
        <li>
            <a href="index.php?page=account">Compte</a>
            <form method ="post" action = "index.php" class ='iconForm'>
                <button type="submit" name = "formName" value="Deconnexion">
                    <img class ='formImageButton' src ='src/Pictures/icons8-shutdown-96.png'></img>
                </button>
            </form>
        </li>
    </ul>

<div>
</div>
        
</header>