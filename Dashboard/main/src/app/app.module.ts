import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
//import {MatMenuModule} from '@angular/material/menu/';
//import { MatButtonModule, MatCardModule, MatMenuModule, MatToolbarModule, MatIconModule, MatSidenavModule, Mat } from '@angular/material/button';





// Reactive Form
import { ReactiveFormsModule } from "@angular/forms";
import {FormsModule} from '@angular/forms';

// App routing modules
import { AppRoutingModule } from './shared/routing/app-routing.module';

// App components
import { AppComponent } from './app.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { VerifyEmailComponent } from './components/verify-email/verify-email.component';

// Firebase services + enviorment module
import { AngularFireModule } from "@angular/fire";
import { AngularFireAuthModule } from "@angular/fire/auth";
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { environment } from '../environments/environment';
import {DropdownModule} from 'primeng/dropdown';



// Auth service
import { AuthService } from "./shared/services/auth.service";
import { WeatherComponent } from '../app/components/weather/weather.component';
import { HttpClientModule } from '@angular/common/http';
import { WeatherdataService } from './shared/services/weatherdata.service';
import { SelectionComponent } from './components/selection/selection.component';
import { DisplayWeatherComponent } from './components/display-weather/display-weather.component';
import { RedditComponent } from './components/reddit/reddit.component';
import { GithubComponent } from './components/github/github.component';
import { TimeAgoPipe } from './shared/pipes/time-ago.pipe';
import { HighlightDirective } from './shared/directives/highlight.directive';
import { YoutubeSearchComponent } from './components/youtube-search/youtube-search.component';
import { SearchInputComponent } from './components/search-input/search-input.component';
import { SearchListComponent } from './components/search-list/search-list.component';
import { SearchContainerComponent } from './components/search-container/search-container.component';
import { DashboarduserComponent } from './components/dashboarduser/dashboarduser.component';
import { AboutJsonComponent } from './components/about-json/about-json.component';
import { WeatherTrueComponent } from './components/weather-true/weather-true.component';
import { CalculatorComponent } from './components/calculator/calculator.component';

//import { MapsComponent } from './components/maps/maps.component';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    DashboardComponent,
    ForgotPasswordComponent,
    VerifyEmailComponent,
    WeatherComponent,
    SelectionComponent,
    DisplayWeatherComponent,
    RedditComponent,
    GithubComponent,
    TimeAgoPipe,
    HighlightDirective,
    YoutubeSearchComponent,
    SearchInputComponent,
    SearchListComponent,
    SearchContainerComponent,
    DashboarduserComponent,
    AboutJsonComponent,
    WeatherTrueComponent,
    CalculatorComponent,
    //MapsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFirestoreModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    DropdownModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatListModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule

  ],
  providers: [AuthService, WeatherdataService],
  bootstrap: [AppComponent],
  entryComponents: [DisplayWeatherComponent],
})

export class AppModule { }
