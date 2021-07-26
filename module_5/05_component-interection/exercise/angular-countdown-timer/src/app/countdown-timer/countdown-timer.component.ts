import {Component, Input, OnInit, OnDestroy, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.scss']
})
export class CountdownTimerComponent implements OnInit, OnDestroy {
  private intervalId: number;
  message = 'Ok';
  remainingTime: number;
  @Input()
  seconds: number;
  @Output() changeCountDown = new EventEmitter();

  constructor() {
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnInit() {
    this.reset();
    this.start();
  }

  ngOnDestroy() {
    this.clearTimer();
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  reset() {
    this.clearTimer();
    this.start();
    this.message = `Click start button to start the Countdown`;
  }

  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      if (this.seconds > 0) {
        this.changeCountDown.emit(this.seconds);
        this.seconds -= 1;
      } else {
        this.changeCountDown.emit('Happy New Year ! ! !');
        this.stop();
      }
    }, 1000);
  }
}
