import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FindPaintComponent} from './components/find-paint/page/find-paint.component';

const routes: Routes = [
  {path: '', component: FindPaintComponent},
  {
    path: 'find-paint',
    loadChildren: () => import('./components/find-paint/page/find-paint.module')
      .then((m) => m.FindPaintModule)
  },
  {
    path: 'paint-management',
    loadChildren: () => import('./components/paint-management/page/paint-management.module')
      .then((m) => m.PaintManagementModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
