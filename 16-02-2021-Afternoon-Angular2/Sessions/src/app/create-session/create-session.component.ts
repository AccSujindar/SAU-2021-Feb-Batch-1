import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../sessions.service';
@Component({
  selector: 'app-create-session',
  templateUrl: './create-session.component.html',
  styleUrls: ['./create-session.component.css']
})
export class CreateSessionComponent implements OnInit {

  sessionName;
  sessionDescription;
  instructorName;
  constructor(private sessionService:SessionService,
    private router: Router) { }

  ngOnInit(): void {
    this.sessionName='';
    this.sessionDescription = '';
    this.instructorName='';
  }

  createSession()
  {
    if(this.sessionName==='' || this.sessionDescription==='' || this.instructorName==='')
    {
      alert("Kinldy fill all the inputs!");
      return false;
    }
    else
    {
      this.sessionService.addSession(this.sessionName,this.sessionDescription,this.instructorName);
      this.sessionName='';
      this.sessionDescription='';
      this.instructorName='';
      this.router.navigate(['/sessions'])
    }
  }
}
