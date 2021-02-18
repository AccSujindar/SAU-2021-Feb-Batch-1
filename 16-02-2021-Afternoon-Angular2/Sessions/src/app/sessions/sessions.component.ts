import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../sessions.service';

@Component({
  selector: 'app-sessions',
  templateUrl: './sessions.component.html',
  styleUrls: ['./sessions.component.css']
})
export class SessionsComponent implements OnInit {

  allSessions:{sessionName:string,description:string,instructorName:string}[] = [];
  constructor(private sessionService:SessionService,
    private router: Router) { }

  ngOnInit(): void {
    this.allSessions = this.sessionService.allSessions;
  }

}
