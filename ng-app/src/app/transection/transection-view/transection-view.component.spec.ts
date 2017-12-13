import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransectionViewComponent } from './transection-view.component';

describe('TransectionViewComponent', () => {
  let component: TransectionViewComponent;
  let fixture: ComponentFixture<TransectionViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransectionViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransectionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
