import { Component, OnInit, NgZone, ViewChild, ViewContainerRef, ComponentRef, ComponentFactoryResolver, ViewRef, Type } from '@angular/core';
import { AuthService } from "../../shared/services/auth.service";
import { Router } from "@angular/router";
import { Weather } from '../../components/weather/weather.component';
import {DisplayWeatherComponent} from '../display-weather/display-weather.component';
import {WeatherTrueComponent} from '../../components/weather-true/weather-true.component';
import {GithubComponent} from '../github/github.component';
import {YoutubeSearchComponent} from '../youtube-search/youtube-search.component';
import {CalculatorComponent} from '../calculator/calculator.component';
@Component({
  selector: 'app-dashboard',
  styleUrls: ['./dashboard.component.css'],
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent   {

  @ViewChild("containerWeather", {read: ViewContainerRef}) containerWeather: ViewContainerRef;
  @ViewChild("containerGithub", {read: ViewContainerRef}) containerGithub: ViewContainerRef;
  @ViewChild("containerYoutube", {read: ViewContainerRef}) containerYoutube: ViewContainerRef;
  @ViewChild("containerCalculator", {read: ViewContainerRef}) containerCalculator: ViewContainerRef;

  weather: Weather = {
    city: "No City",
    conditions: "-",
    temperature: 0,
    icon: "",
    code:"",
    humidity: 0,
    wind:0,

  }
  components = [];

  compo : ComponentRef<WeatherTrueComponent>;

  weatherCompo = WeatherTrueComponent;
  githubCompo = GithubComponent;
  youtubeCompo = YoutubeSearchComponent;
  calcuCompo = CalculatorComponent;

  constructor(
    public authService: AuthService,
    public router: Router,
    public ngZone: NgZone,
    private componentFactoryResolver: ComponentFactoryResolver

  ) { }

  addNewComponentWeather(componentClass: Type<any>) {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const component = this.containerWeather.createComponent(componentFactory);
    this.components.push(component);

  }

  removeComponentWeather() {
    this.containerWeather.remove(this.containerWeather.length - 1);
  }

  addNewComponentGithub(componentClass: Type<any>) {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const component = this.containerGithub.createComponent(componentFactory);
    this.components.push(component);

  }

  removeComponentGithub() {
    this.containerGithub.remove(this.containerGithub.length - 1);
  }

  addNewComponentYoutube(componentClass: Type<any>) {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const component = this.containerYoutube.createComponent(componentFactory);
    this.components.push(component);

  }

  removeComponentYoutube() {
    this.containerYoutube.remove(this.containerYoutube.length - 1);
  }


  addNewComponentCalculator(componentClass: Type<any>) {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const component = this.containerCalculator.createComponent(componentFactory);
    this.components.push(component);

  }

  removeComponentCalculator() {
    this.containerCalculator.remove(this.containerCalculator.length - 1);
  }


  update(weather: Weather) {
    this.weather = weather
  }

}
