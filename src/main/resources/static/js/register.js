var Registration = new Vue({
  el: '#form-register',
  data: {
        errors : [],
        selectCountry : false,
        c : null,
        argentina : null,
        provSelected : null,
        user : {
            firstName :         null,
            lastName :          '',
            address:            '',
            street:             '',
            streetNumber :      '',
            cel:                '',
            tel:                '',
            role:               'COMMON',
            celVerified:        false,
            username :          '',
            password :          '',
            email :             ''
        }
  }, 
  mounted:function(){
        this.countries();
        this.argentine();
  },
  methods: {
    countries: function() {
        this.$http.get('http://localhost:8080/countries').then(function(response){
            //Método que se dispara cuando vuelve la respuesta del servidor.
            this.c = response.body;
        }, function(){
            //Método que se dispara si hubo algún error.
        });
    },
    argentine : function() {
        this.$http.get('http://localhost:8080/argentina').then(function(response){
            //Método que se dispara cuando vuelve la respuesta del servidor.
            this.argentina = response.body;
        }, function(){
            //Método que se dispara si hubo algún error.
        });
    },
    onChange : function(provSelected) {
        //this.localidades = provSelected.localidades;
    },
    validateForm : function() {
        this.errors = [];

        var constraints = {
            email: {
                email: {
                    message : 'no valido. Posiblemente este vacio o con formato incorrecto'
                }
            },
            nombre : {
                presence : {
                    message : 'no valido, no puede ser vacio'
                }
            },
            password : {
                presence : {
                    message : 'Password requerido'
                },
                length : {
                    minimum : 6,
                    message : 'no valido, la longitud minima es de 6 caracteres'
                }
            },
            cel : {
                numericality : {
                    onlyInteger : true,
                    message : 'no es un numero valido'
                },
                presence : {
                    message : 'requerido'
                },
                length: {
                    minimum: 6,
                    message : 'la longitud minima es de 6 numeros'
                }
            }
        };

        let v = validate({
            nombre : this.user.firstName,
            password : this.user.password,
            email : this.user.email,
            cel : this.user.cel
        }, constraints);

        if (v == undefined) {
            //No errors, register please
            this.$http.post('http://localhost:8080/users/register',{
                    name : this.user.firstName,
                    email : this.user.email
            }).then(function(response){
                    //Método que se dispara cuando vuelve la respuesta del servidor.
                    let status = response.body.status;
                    if (status == 200) {
                        //Email enviado
                        alertify.alert()
                            .setting({
                              'label':'Genial',
                              'title' : 'Email enviado correctamente',
                              'onok': function(){ 
                                  alertify.success('Listo');
                              }
                            })
                          .setContent(`
                              <h4>Verifica tu casilla</h4>
                              <p>
                                  Hemos enviado un email de bienvenida a tu correo.
                              </p><br />
                              <p>
                                  Esperamos disfrutes de tu cuenta en nuestra plataforma.
                                  Nuevamente: Bienvenido!
                              </p>
                          `)
                          .show();
                          
                          
                    }
                    if (status == 400) {
                        //Error en el envio
                        alertify.alert()
                            .setting({
                              'label':'Bueno',
                              'title' : 'Error en el envio de email',
                              'onok': function(){ 
                                  alertify.success('Esperare');
                              }
                            })
                          .setContent(`
                              <h4>Ocurrio un error</h4>
                          `)
                          .show();
                    }
            }, function(){
                    //Método que se dispara si hubo algún error.
            });

            firebase.auth().createUserWithEmailAndPassword(this.user.email, this.user.password).then(function(user) {
                
            }, function(error) {
                // Handle Errors here.
                var errorCode = error.code;
                var errorMessage = error.message;

                if (errorCode == 'auth/email-already-in-use') {
                    //get the closable setting value.
                    var closable = alertify.alert().setting('closable');
                    //grab the dialog instance using its parameter-less constructor then set multiple settings at once.
                    alertify.alert()
                      .setting({
                        'label':'Entiendo',
                        'title' : 'Ya existe un usuario con ese email',
                        'onok': function(){ 
                            alertify.success('Intentalo de nuevo');
                            setTimeout(function() {
                                document.getElementById("user-email").focus();
                            }, 1000);
                        }
                      })
                    .setContent(`
                        <h4>El usuario debe ser único</h4>
                        <p>
                            Nuestras políticas de acceso exigen que un usuario
                            tenga asociado un solo correo electrónico.
                        </p><br />
                        <p>
                            Posiblemente estes intentando registrar un usuario
                            ya existente, si olvidaste tu password puedes solicitar
                            que <a href="#">se restablezca el password de acceso</a>
                        </p>
                    `)
                    .show();
                }
            });

            return;
        }

        if (v.email && v.email.length) {
            this.errors.push(v.email[0]);
        }
        if (v.nombre && v.nombre.length) {
            this.errors.push(v.nombre[0]);
        }
        if (v.password && v.password.length) {
            this.errors.push(v.password[0]);
        }
        if (v.cel && v.cel.length) {
            this.errors.push(v.cel[0]);
        }
    }
  },
    computed : {
        localidades : function() {
            if (this.provSelected !== null) {
                return this.provSelected.localidad;
            }
            return [];
        },
        validationErrors : function () {
            return this.errors;
        }
    }
});
