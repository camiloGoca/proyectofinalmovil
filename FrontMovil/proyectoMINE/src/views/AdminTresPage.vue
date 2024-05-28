<!-- src/views/AgregarIngredientes.vue -->
<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Agregar Ingredientes</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content class="ion-padding">
      <ion-grid>
        <ion-row>
          <ion-col>
            <h2>Nombres</h2>
            <ion-list>
              <ion-item v-for="(nombre, index) in nombres" :key="index">
                <ion-input v-model="nombres[index]" placeholder="Nombre"></ion-input>
              </ion-item>
            </ion-list>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Cantidades</h2>
            <ion-list>
              <ion-item v-for="(cantidad, index) in cantidades" :key="index">
                <ion-input v-model="cantidades[index]" placeholder="Cantidad"></ion-input>
              </ion-item>
            </ion-list>
          </ion-col>
        </ion-row>
        <ion-row>
          <ion-col>
            <h2>Unidades de medida</h2>
            <ion-list>
              <ion-item v-for="(unidad, index) in unidades" :key="index">
                <ion-input v-model="unidades[index]" placeholder="Unidad"></ion-input>
              </ion-item>
            </ion-list>
          </ion-col>
        </ion-row>
      </ion-grid>
      <ion-button @click="guardarIngrediente" expand="full" color="success">Agregar Ingrediente</ion-button>
      <ion-button @click="navigateTo('lista-recetas')" expand="full" color="primary">Lista de Recetas</ion-button>
    </ion-content>
  </ion-page>
</template>

<script>
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import axios from '../axios';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow, IonCol, IonList, IonItem, IonInput, IonButton } from '@ionic/vue';

export default {
  name: 'AgregarIngredientes',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonRow,
    IonCol,
    IonList,
    IonItem,
    IonInput,
    IonButton
  },
  setup() {
    const router = useRouter();
    const route = useRoute();
    const recetaId = route.query.recetaId;

    const nombres = ref(['']);
    const cantidades = ref(['']);
    const unidades = ref(['']);

    const guardarIngrediente = async () => {
      const ingredientes = nombres.value.map((nombre, index) => ({
        nombre,
        cantidad: cantidades.value[index],
        unidadDeMedida: unidades.value[index],
        receta: { id: recetaId }
      }));

      try {
        for (const ingrediente of ingredientes) {
          await axios.post('/ingrediente/save', ingrediente);
        }
        console.log('Ingredientes guardados con éxito');
      } catch (error) {
        console.error('Error al guardar los ingredientes:', error);
      }
    };

    const navigateTo = (path) => {
      router.push({ path: `/${path}` });
    };

    return {
      nombres,
      cantidades,
      unidades,
      guardarIngrediente,
      navigateTo
    };
  }
};
</script>

<style scoped>
ion-header {
  --background: #32d296;
  --color: white;
}

h2 {
  margin: 0;
  padding: 10px 0;
  color: #32d296;
}
</style>
