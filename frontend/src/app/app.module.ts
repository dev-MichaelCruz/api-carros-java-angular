import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './shared/card/card.component';
import { HomeComponent } from './pages/home/home.component';
import { CardInicioComponent } from './components/card-inicio/card-inicio.component';
import { CadastroFormComponent } from './components/cadastro-form/cadastro-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HomeComponent,
    CardInicioComponent,
    CadastroFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
