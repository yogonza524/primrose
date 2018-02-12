var templates = new Vue({
  el: '#topBarMenu',
  data: {
     template: `<div id="menuTopHome" >
            <a class="active item">
              Publicaciones
            </a>
            <a class="item">
              <div class="ui icon input">
                <input type="text" placeholder="Buscar publicaciones..." />
                <i class="search icon"></i>
              </div>
            </a>
            <div class="right menu">
              <a class="ui item">
                Publicar
              </a>
              <a class="ui item">
                Publicar en Facebook
              </a>
              <a class="ui item" href="/register">
                Registrarme
              </a>
              <a class="ui item">
                Acceder
              </a>
            </div>
        </div>
        <script>
            $("#menuTopHome").sticky({
                topSpacing:0,
                zIndex: 9999
            });
        </script>
    `
  }
});
