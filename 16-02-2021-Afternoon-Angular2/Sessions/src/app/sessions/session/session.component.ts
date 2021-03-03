import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SessionService } from '../../sessions.service';
@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css']
})
export class SessionComponent implements OnInit {
  currentId: number;
  currentSession:{sessionName:string,description:string,instructorName:string};

  constructor(private sessionService:SessionService,
    private route:ActivatedRoute,
    private router: Router ) { }

  ngOnInit(): void {
    this.currentId = this.route.snapshot.params['id'];
    if(this.currentId < 0 || this.sessionService.allSessions.length===0 || this.currentId >= this.sessionService.allSessions.length)
    {
      this.router.navigate(['/sessions']);
    }
    this.currentSession = this.sessionService.getSession(this.currentId);
    this.route.params.subscribe((params: Params)=>{
      this.currentId = params['id'];
      this.currentSession = this.sessionService.getSession(this.currentId);
    });
  }
  deleteSession()
  {
    if(confirm("Are you sure ?"))
    {
      this.sessionService.deleteSession(this.currentId);
      this.router.navigate(['/sessions']);
    }
  }

}
