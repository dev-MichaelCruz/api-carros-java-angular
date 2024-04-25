import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CardInicioComponent } from './components/card-inicio/card-inicio.component';
import { CadastroFormComponent } from './components/cadastro-form/cadastro-form.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaComponent } from './pages/lista/lista.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CardInicioComponent,
    CadastroFormComponent,
    ListaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
