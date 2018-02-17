$("#menuTopHome,#topBarMenu").sticky({
    topSpacing:0,
    zIndex: 9999
});

$("#itemsTypeRightHome").sticky({
    topSpacing:65,
    responsiveWidth: true
});

// register
Vue.component('publication', {
  template: `
    <div style="margin-bottom:10px" class="ui form">
        <div class="ui menu">
            <label class="" for="upload-image">
                <a class="item">
                    <i class="image icon"></i>
                    <input style="display:none; position:absolute; left:9999;" type="file" id="upload-image" class="upload-image-hidden" />
                </a>
            </label>
            <a class="item">
               Rubros
            </a>
            <div class="right menu">
              <a class="item">Publicar</a>
            </div>
        </div>
        <div class="ui secondary segment">
          <div class="field">
            <label>Quiero publicar...</label>
            <textarea placeholder="Articulos, búsqueda laboral, persona extraviada, terreno, alquiler..."></textarea>
          </div>
        </div>
    </div>
    `
})

// create a root instance
new Vue({
  el: '#publication-master'
})