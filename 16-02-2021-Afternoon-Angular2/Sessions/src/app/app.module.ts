import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSessionComponent } from './create-session/create-session.component';
import { SessionsComponent } from './sessions/sessions.component';
import { SessionComponent } from './sessions/session/session.component';
import { EditSessionComponent } from './sessions/edit-session/edit-session.component';
import {SessionService} from './sessions.service';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NotFoundComponent } from './not-found/not-found.component';
const appRoutes : Routes = [
  {path: '', component: CreateSessionComponent},
  {path: 'sessions', component: SessionsComponent, children: [
    {path: ':id', component: SessionComponent},
    {path: ':id/edit', component:EditSessionComponent}
  ]},
  {path: '**', component: NotFoundComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    CreateSessionComponent,
    SessionsComponent,
    SessionComponent,
    EditSessionComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    MatCardModule,
    BrowserAnimationsModule
  ],
  providers: [SessionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
