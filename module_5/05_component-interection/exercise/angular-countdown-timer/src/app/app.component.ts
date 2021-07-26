import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-countdown-timer';
  output: number;
  input: number;

  changeTimer(value) {
    this.output = value;
  }
}
