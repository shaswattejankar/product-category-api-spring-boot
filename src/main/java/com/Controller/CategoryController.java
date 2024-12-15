package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Entity.Category;
import com.Repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
    public ResponseEntity<Page<Category>> getCategories(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return ResponseEntity.ok(categories);
    }
	
	@PostMapping
	public ResponseEntity<Category> createCategory( @RequestBody Category category ){
		Category savedCategory = categoryRepository.save(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById( @PathVariable Long id ){
		Category fetchedCategory = categoryRepository.findById(id).orElse(null);
		return (fetchedCategory != null)? ResponseEntity.ok(fetchedCategory) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategoory( @PathVariable Long id, @RequestBody Category category ){
		if(categoryRepository.existsById(id)) {
			category.setId(id);
			return ResponseEntity.ok(categoryRepository.save(category));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory( @PathVariable Long id ){
		if (categoryRepository.existsById(id)) {
	        categoryRepository.deleteById(id);
	        return ResponseEntity.ok("Category with ID " + id + " has been successfully deleted.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Category with ID " + id + " not found.");
	    }
	}
	
}














