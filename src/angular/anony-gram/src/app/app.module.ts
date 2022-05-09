import { APP_BOOTSTRAP_LISTENER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { CanActivate } from '@angular/router';
import { DoBootstrap } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { InfoChatComponent } from './info-chat/info-chat.component';
import { MensajesComponent } from './mensajes/mensajes.component';
import { InfoUserComponent } from './info-user/info-user.component';
import { ChatComponent } from './chat/chat.component';
import { SendMessageComponent } from './send-message/send-message.component';
import { SearchChatComponent } from './search-chat/search-chat.component';
import { CardChatComponent } from './card-chat/card-chat.component';
import {MatCardModule} from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MensajePropioComponent } from './mensaje-propio/mensaje-propio.component';
// import { CanActivateAuthInstaService } from './services/can-activate-auth-insta.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    InfoChatComponent,
    MensajesComponent,
    InfoUserComponent,
    ChatComponent,
    SendMessageComponent,
    SearchChatComponent,
    CardChatComponent,
    MensajePropioComponent,
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    SharedModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatCardModule,
    MatDialogModule
  ],
  bootstrap: [AppComponent] 
})
export class AppModule { }
