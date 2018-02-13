$("#menuTopHome,#topBarMenu").sticky({
    topSpacing:0,
    zIndex: 9999
});

$("#itemsTypeRightHome").sticky({
    topSpacing:65,
    responsiveWidth: true
});

//Firebase access
firebase.auth().signInWithEmailAndPassword("yogonza524@gmail.com", "12345").catch(function(error) {
  // Handle Errors here.
  var errorCode = error.code;
  var errorMessage = error.message;

  alert(errorMessage);
  // ...
});