import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { CardChatComponent } from './card-chat/card-chat.component';
import { ChatComponent } from './chat/chat.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CanActivateAuthInstaService } from './services/can-activate-auth-insta.service';
//, canActivate: [CanActivateAuthInstaService]
const routes: Routes = [
  {path: "", component: AppComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "chat", component: ChatComponent},
  {path: "chat2", component: CardChatComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
