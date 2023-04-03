import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeatherTrueComponent } from './weather-true.component';

describe('WeatherTrueComponent', () => {
  let component: WeatherTrueComponent;
  let fixture: ComponentFixture<WeatherTrueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeatherTrueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeatherTrueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
