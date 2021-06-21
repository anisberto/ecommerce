import { Component } from '@angular/core';

@Component({
  selector: 'sup-root',
  template: `
  <sup-navbar></sup-navbar>
  <router-outlet></router-outlet>
  `,
  styles: []
})
export class AppComponent {
  title = 'supera';
}
