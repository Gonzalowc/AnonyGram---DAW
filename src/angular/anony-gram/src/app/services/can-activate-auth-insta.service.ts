import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class CanActivateAuthInstaService implements CanActivate {

  constructor(private authService: LoginService ,private router: Router) { }

  canActivate(){
    if(!this.authService.isLogged()){
      console.log("No está logueado");
      this.router.navigate(['/']);
      return false;
    }
    return true;
  }
}
