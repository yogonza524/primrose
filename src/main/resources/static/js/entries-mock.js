var mockEntries = new Vue({
  el: '#entries',
  data: {
    entries: [
        { 
            id: 32453,
            item: {
                id: 5,
                name: 'Empleos y Oficios Varios'
            },
            sponsored: false,
            userFriendly: null,
            title: 'Amodil busca revendedoras',
            desc:  'Si queres tener un ingreso extra, mejorando tu tiempo ' +
                   '!No dudes mas! De regalo Kit de productos + perfume +' +
                   ' remera + bolso y mucho mas. Vamos al interior.',
            contacts : [
                   'Roxana 3794896196' 
            ],
            created: 'Sun Feb 11 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 11 2018 21:07:55 GMT-0300',
            social: {
                seen: 23,
                like: 4,
            }
        },
        { 
            id: 32454,
            item: {
                id: 5,
                name: 'Empleos y Oficios Varios'
            },
            sponsored: false,
            userFriendly: null,
            title: 'Amodil',
            desc:  'Busco revendedoras. Llevate una pava eléct. Enviá un SMS o llamar al ' +
                   '3794665571',
            contacts : [],
            created: 'Sun Feb 10 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 11 2018 21:07:55 GMT-0300',
            social: {
                seen: 6,
                like: 1,
            }
        },
        { 
            id: 32454,
            item: {
                id: 34,
                name: 'Carnavales'
            },
            sponsored: true,
            userFriendly: null,
            title: '',
            desc:  '',
            contacts : [],
            pictureUrl: 'http://www.chacodiapordia.com/wp-content/uploads/2018/01/Carnaval_Ctes.jpg',
            created: 'Sun Feb 10 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 11 2018 21:07:55 GMT-0300',
            social: {
                seen: 465,
                like: 342,
            }
        },
        { 
            id: 32455,
            item: {
                id: 12,
                name: 'Resto Bar'
            },
            sponsored: false,
            userFriendly: null,
            title: 'Pizza Hot Resto Bar Corrientes',
            desc:  'Promociones. Pizza por metro $180, Empanadas x docena $100, ' +
                    'Pastas desde $55 (la porcion), BRAHMA-QUILMES (litro) $60, ' + 
                    'MENU EJECUTIVO (almuerzo) $55',
            contacts : [
                'Tel. 4436017 Av. Pujol 1848'
            ],
            pictureUrl: '',
            created: 'Sun Feb 10 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 11 2018 21:07:55 GMT-0300',
            social: {
                seen: 11,
                like: 7,
            }
        },
        { 
            id: 32456,
            item: {
                id: 8,
                name: 'Institutos'
            },
            sponsored: true,
            userFriendly: null,
            title: 'Abierta la inscripción Ciclo 2018',
            desc:  '',
            contacts : [],
            pictureUrl: 'https://www.guianea.com/images/stories/cecalposadasmisiones/200x200cecalposadasmisiones.jpg',
            created: 'Sun Feb 10 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 11 2018 21:07:55 GMT-0300',
            social: {
                seen: 354,
                like: 223,
            }
        },
        { 
            id: 32457,
            item: {
                id: 8,
                name: 'Maquillaje'
            },
            sponsored: false,
            userFriendly: null,
            title: 'Martina Maquillajes. Maquillaje artístico',
            desc:  '',
            contacts : [],
            pictureUrl: 'https://imgur.com/pyYoORT.png',
            created: 'Sun Feb 10 2018 14:07:55 GMT-0300',
            updated: '',
            expire: 'Sun Feb 15 2018 21:07:55 GMT-0300',
            social: {
                seen: 765,
                like: 467,
            }
        }
    ]
  },
    methods: {
        getCreated: function(entry) {
            let date = moment(entry.created);
            return date.format("DD") + "/" + (date.month() + 1) + "/" + date.year();
        },
        hasTitle: function(entry) {
            return entry.title !== ''; 
        },
        hasPicture: function(entry) {
            return entry.pictureUrl !== '';
        },
        hasDescription: function(entry) {
            return entry.desc !== '';
        }
    }
});

