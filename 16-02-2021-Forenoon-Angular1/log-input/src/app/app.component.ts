import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  inputText;
  logs: string[] = [];
  ngOnInit()
  {
    this.inputText = "";
  }

  addLog()
  {
    this.logs.push(this.inputText);
    this.inputText = "";
  }


}
