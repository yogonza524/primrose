var Registration = new Vue({
  el: '#form-login',
  data: {
    errors : [],
    email : null,
    password: null,
  },
  methods: {
    login : function() {
        var constraints = {
            email : {
                email: {
                    message : 'no valido. Posiblemente este vacio o con formato incorrecto'
                },
                presence : {
                    message : 'requerido'
                }
            },
            password : {
                presence : {
                    message : 'requerido'
                },
                length : {
                    minimum : 6,
                    message : 'no valido, la longitud minima es de 6 caracteres'
                }
            }
        };

        let v = validate({
            email : this.email,
            password : this.password
        }, constraints);

        if (v == undefined) {
            //No errors, try login please

            return;
        }

        this.errors = [];
        
        let messageEmail = null;
        let messagePass = null;
        
        if (v.email && v.email.length) {
            messageEmail = v.email[0];
        }

        if (v.password && v.password.length) {
            messagePass = v.password[0];
        }

        //Show errors
        this.errors.push(messageEmail);
        this.errors.push(messagePass);

        //this.validateErrors = errors;
    }
  },
  computed: {
    validateErrors : function() {
        return this.errors;
    }
  }
});
