import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {WeatherdataService} from '../../shared/services/weatherdata.service';
import {Weather} from '../../components/weather/weather.component';
import { FormsModule} from '@angular/forms';
import { from } from 'rxjs';

@Component({
  selector: 'app-selection',
  templateUrl: './selection.component.html',
  styleUrls: ['./selection.component.css']
})
export class SelectionComponent {
  @Output() onSelection: EventEmitter<Weather> = new EventEmitter<Weather>()
  weather: Weather = new Weather()
  city: String = ""
  code: String = ""

  constructor(private weatherData: WeatherdataService) { }

  submit() {
    this.weatherData.load(this.city).subscribe(data => {
      this.weather.city = data['name']
      this.weather.humidity = Math.round((data['main']['humidity']))
      this.weather.wind = Math.round((data['main']['wind.speed'] - 273.15)*1.8 + 32)
      this.weather.conditions = data['weather'][0]['main']
      this.weather.temperature = Math.round((data['main']['temp'] - 273.15)*1.8 + 32)
      this.weather.icon = this.weatherData.getIconUrl(data['weather'][0]['icon'])

      this.onSelection.emit(this.weather)

    })
  }
  submitcode() {
    this.weatherData.loadcode(this.code).subscribe(data => {
      this.weather.city = data['name']
      this.weather.conditions = data['weather'][0]['main']
      this.weather.temperature = Math.round((data['main']['temp'] - 273.15)*1.8 + 32)
      this.weather.icon = this.weatherData.getIconUrl(data['weather'][0]['icon'])

      this.onSelection.emit(this.weather)

    })
    

  }


  update(weather: Weather) {
    this.weather = weather
  }
}

